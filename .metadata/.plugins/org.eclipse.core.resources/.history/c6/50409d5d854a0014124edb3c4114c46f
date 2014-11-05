package com.cchub.cityguide;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.codecamp.libs.RestClient;
import com.codecamp.libs.RestClient.RequestMethod;

public class MainActivity extends ActionBarActivity implements
		
		NavigationDrawerFragment.NavigationDrawerCallbacks {
	 static double latitude;
	 static double longitude;
	
	Button proceed;
	static GPSTracker gps;
	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;
	private CharSequence mTitle1;
	static ArrayList<ImageItem> imageList;
	static ListView ls;
	static Context ctx;
	static ProgressDialog pDialog;
	static String images = "CompanyLogo";
	//ImageLoader imageloader = new ImageLoader(this);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ctx = getApplicationContext();
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();
		pDialog = new ProgressDialog(MainActivity.this);
		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
//		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
//				.findFragmentById(R.id.navigation_drawer);
//		mTitle = getTitle();
//
//		// Set up the drawer.
//		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
//				(DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		ArrayList<Parent> p = new ArrayList<Parent>();
		for(int i = 0; i < p.size(); i++){
			mTitle = p.get(i).getChildren().get(number).getChildText();
		}
//		switch (number) {
//		case 1:
//			mTitle = getString(R.string.title_section1);
//			break;
//		case 2:
//			mTitle = getString(R.string.title_section2);
//			break;
//		case 3:
//			mTitle = getString(R.string.title_section3);
//			break;
//		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
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
	public static class PlaceholderFragment extends Fragment {
		ImageViewAdapter adapter;
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_image_list_view, container,
					false);
			ls = (ListView) rootView.findViewById(R.id.listView);
			imageList = new ArrayList<ImageItem>();
			if (!imageList.isEmpty()) {
				 adapter = new ImageViewAdapter(getActivity(),
						R.layout.selected, imageList);
				ls.setAdapter(adapter);
			}

//			ls.setOnItemClickListener(new OnItemClickListener() {
//
//				@Override
//				public void onItemClick(AdapterView<?> arg0, View arg1,
//						int arg2, long arg3) {
//					AlertDialog.Builder builder = new AlertDialog.Builder(
//							getActivity());
//					builder.setTitle("ALERT");
//					builder.setMessage("This is a Dialog").setCancelable(true);
//					builder.setNeutralButton("Dassall", null);
//					builder.create().show();
//					Intent i = new Intent(getActivity(),ViewBusiness.class);
//					i.putExtra("longitude", longitude);
//					i.putExtra("lattitude", latitude);
//					i.putExtra("businessid", 211242);
//					startActivity(i);
//				}
//
//			});
//			
//			gps = new GPSTracker(getActivity());
//	        // check if GPS enabled       
//	        if(gps.canGetLocation()){                  
//	             latitude = gps.getLatitude();
//	            longitude = gps.getLongitude();                   
//	            // \n is for new line
//	            Toast.makeText(getActivity().getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();   
//	        }else{
//	            // can't get location
//	            // GPS or Network is not enabled
//	            // Ask user to enable GPS/network in settings
//	            gps.showSettingsAlert();
//	        }
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
		
		public static void getValues(String cat, String id) {
			MainActivity.PlaceholderFragment x = new PlaceholderFragment();
			x.new MyAsyncTask().execute(cat,id);
		}

		class MyAsyncTask extends AsyncTask<String, Void, String> {

			private RestClient connect;
			private String text;
			//ProgressDialog pDialog;
			ArrayList<String> data;
			Child child = new Child();

			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
				pDialog.setMessage("Loading... ");
				pDialog.show();
			}

			@Override
			protected String doInBackground(String... arg0) {
				// TODO Auto-generated method stub
				String category = arg0[0];
				String catid = arg0[1];
				//Intent x = getActivity().getIntent();
				//String address = x.getStringExtra("address");
				//String apiUrl2 = "http://72.251.246.227/vconnect_restservice_hack_2014/VConnect.svc/GetBusinessDetails?BusinessId=" + catid;
				String apiUrl = "http://72.251.246.227/vconnect_restservice_hack_2014/VConnect.svc/GetSearchByCategory?KeyWord"
						+ "="
						+ category
						+ "&Location="
						+ "yaba"
						+ "&contentid="
						+ catid
						+ "&pageNum="
						+ 3
						+ "&rowsPerPage=" + 10;
				connect = new RestClient(apiUrl);
				try {
					connect.Execute(RequestMethod.GET);
					text = connect.getResponse();

					JSONObject object = new JSONObject(text);
					object.get("ResponseCode");
					JSONArray dataObject = object.getJSONArray("SearchList");
					imageList.clear();
					for (int i = 0; i < dataObject.length(); i++) {
						Vconnect v = new Vconnect(
								(JSONObject) dataObject.get(i));
						imageList
								.add(new ImageItem(v.getBussinessAddress(),v.getBusinessName(),
										R.drawable.god1, v.getBusinessIDs()));
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				//data.addAll(data);
				 adapter = new ImageViewAdapter(
						ctx, R.layout.selected, imageList);
				adapter.notifyDataSetChanged();
				ls.setAdapter(adapter);
				pDialog.dismiss();
			}
		}
		
	}

}
