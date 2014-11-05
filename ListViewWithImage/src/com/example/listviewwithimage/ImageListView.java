package com.example.listviewwithimage;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ImageListView extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_list_view);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_list_view, menu);
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
	public static class PlaceholderFragment extends Fragment {
		static ArrayList<ImageItem> imageList = new ArrayList<ImageItem>();
		
		static{
				imageList.add(new ImageItem("This is a Title", "A Description to this image, Or Click the image to see the Progress Dialog", R.drawable.god));
				imageList.add(new ImageItem("This is a Title", "A Description to this image, Or Click the image to see the Progress Dialog", R.drawable.god1));
				imageList.add(new ImageItem("This is a Title", "A Description to this movie, Or Click the image to see the Progress Dialog", R.drawable.god3));
				imageList.add(new ImageItem("This is a Title", "A Description to this movie, Or Click the image to see the Progress Dialog", R.drawable.god3));
				imageList.add(new ImageItem("This is a Title", "A Description to this movie, Or Click the image to see the Progress Dialog", R.drawable.god));
		}
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_image_list_view,
					container, false);
			ListView ls = (ListView)rootView.findViewById(R.id.listView);
			ImageViewAdapter adapter = new ImageViewAdapter(getActivity(), R.layout.selected,imageList);
			ls.setAdapter(adapter);
			ls.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
					builder.setTitle("ALERT");
					builder.setMessage("This is a Dialog").setCancelable(true);
					builder.setNeutralButton("Dassall", null);
					builder.create().show();
				}
				
			});
			
			return rootView;
		}
	}
}
