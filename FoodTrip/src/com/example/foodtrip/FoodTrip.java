package com.example.foodtrip;


import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FoodTrip extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_trip);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.food_trip, menu);
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
		ListView ls;
		RestaurantAdapter adapter;
		static ArrayList<Restaurant>  model = new ArrayList<Restaurant>();
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.fragment_food_trip,
					container, false);
			adapter = new RestaurantAdapter(getActivity(), R.layout.row, model);
			
			Button save = (Button)rootView.findViewById(R.id.btn_save);
			ls = (ListView)rootView.findViewById(R.id.restaurants);
			
			save.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					
					EditText name = (EditText)rootView.findViewById(R.id.field_name);
					EditText address = (EditText)rootView.findViewById(R.id.field_address);
					RadioGroup type = (RadioGroup)rootView.findViewById(R.id.rgrp_types);
					
					String names = name.getText().toString();
					String addresses = address.getText().toString();
					Restaurant r = new Restaurant();
					
					switch (type.getCheckedRadioButtonId()) {
					case R.id.rbtn_sit_down:
						r.setType("sit_down");
						break;
					case R.id.rbtn_take_out:
						r.setType("take_out");
						break;
					case R.id.rbtn_delivery:
						r.setType("delivery");
						break;
					}
					
						model.add(new Restaurant(names, addresses, R.drawable.ic_launcher, r.getType()));
					
					((EditText) rootView.findViewById(R.id.field_name)).setText("");
					((EditText) rootView.findViewById(R.id.field_address)).setText("");
					
					((RadioGroup) rootView.findViewById(R.id.rgrp_types)).clearCheck();
					
					((EditText)rootView.findViewById(R.id.field_name)).requestFocus();
					
					ls.setAdapter(adapter);
				}
			});
			
			return rootView;
		}
	}
}
