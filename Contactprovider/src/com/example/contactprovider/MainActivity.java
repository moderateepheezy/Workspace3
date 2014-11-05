package com.example.contactprovider;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.example.contactprovider.data.Pair;

public class MainActivity extends ActionBarActivity {
	static final String TAG = MainActivity.class.getSimpleName();
	android.app.ActionBar actionBar;
	android.app.ActionBar.TabListener tabListener;
	android.app.ActionBar.Tab profileTab;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		tabListener = new TabListener();
		
		profileTab =actionBar.newTab().setText("Profile").setTabListener(tabListener);
		actionBar.addTab(profileTab);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_USE_LOGO);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		Log.i("", "" + Thread.currentThread().getId());
	}
	
	public class TabListener implements android.app.ActionBar.TabListener{

		@Override
		public void onTabReselected(android.app.ActionBar.Tab arg0,
				FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(android.app.ActionBar.Tab tab,
				FragmentTransaction ft) {
			// TODO Auto-generated method stub
			Log.i("",""+Thread.currentThread().getId());
			CharSequence tabText = tab.getText();
			Log.i(TAG, tabText.toString());
			if(tabText.equals("Profile")) {			
				new LinkProfileTask().execute();
			}
		}

		@Override
		public void onTabUnselected(android.app.ActionBar.Tab arg0,
				FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public class ProfileFragment extends ListFragment{
		
		private ProfileAdapter mAdapter;
		private List<Pair> pairList = null;
		private LayoutInflater mInflater;
		public boolean taskRun;
		
		public ProfileFragment(){
			pairList = new LinkedList<Pair>();
		}
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			mInflater = (LayoutInflater)getActivity().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			if(!taskRun){
				FragmentTransaction ft = getFragmentManager().beginTransaction();
				LinkProfileTask task = new LinkProfileTask();
				task.execute();
			}
			taskRun = true;
			mAdapter = new ProfileAdapter(getActivity(),R.layout.fragment_main, R.id.key, pairList);
			mAdapter.setInflater(mInflater);
			mAdapter.setLayout(R.layout.fragment_main);
			setListAdapter(mAdapter);
			getListView().invalidate();
		}
		
		public void setDataList(List<Pair> result) {
			this.pairList = result;
			Activity act = getActivity();
			taskRun = true;
			if(act != null){
				mInflater = (LayoutInflater) getActivity().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
				mAdapter = new ProfileAdapter(getActivity(), R.layout.fragment_main,R.id.key, result);
				mAdapter.setLayout(R.layout.fragment_main);
				mAdapter .setInflater(mInflater);
				setListAdapter(mAdapter );
				getListView().invalidate();
			}
		}
	}
	public class LinkProfileTask extends AsyncTask<Void, Void, List<Pair>> {
		private FragmentTransaction ft;
		private Activity activity;

		@Override
		protected List<Pair> doInBackground(Void... arg0) {
			Log.i("", "AynckTask syncronize thread Profile"
					+ Thread.currentThread().getId());
			Cursor c = activity.getContentResolver().query(
					ContactsContract.Profile.CONTENT_URI, null, null, null, null);
			int count = c.getCount();
			
			String[] columnNames = c.getColumnNames();
			List<Pair> profileList = new LinkedList<Pair>();
			boolean b = c.moveToFirst();
			int position = c.getPosition();
			if(count ==1 && position == 0){
				for(int i = 0; i < count; i ++){
					for(int j = 0; j < columnNames.length; j++){
						String columnName = columnNames[j];
						Pair pair = new Pair(columnName, c.getString(c.getColumnIndex(columnName)));
						profileList.add(pair);
					}
					boolean b2 = c.moveToNext();
				}
			}
			c.close();
			return profileList;
		}
		
		@Override
		protected void onPostExecute(List<Pair > result) {
			ProfileFragment profileFragment = (ProfileFragment) activity
					.getFragmentManager().findFragmentByTag("Profile");
			if (profileFragment == null) {
				profileFragment = new ProfileFragment();
			}
			profileFragment.setDataList(result);
			Intent i = activity.getIntent();
			ft.replace(R.id.fragment_container, profileFragment, "Profile");
			ft.commit();
			profileFragment.taskRun = true;
		}
	}
}
