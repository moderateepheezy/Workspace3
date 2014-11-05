package com.example.foodtrip;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantAdapter extends ArrayAdapter<Restaurant>{
	TextView name;
	TextView address;
	ImageView icon;
	
	
    ArrayList<Restaurant> model;
	Context context;
	int layout;
	
	static FoodTrip.PlaceholderFragment pr = new FoodTrip.PlaceholderFragment();
	
	public RestaurantAdapter(Context context, int layout, ArrayList<Restaurant> model) {
		super(context, layout, model);
		this.context = context;
		this.layout = layout;
		this.model = model;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View row = convertView;
		
		if(row == null){
			LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(this.layout, null);
		}
			name = (TextView) row.findViewById(R.id.row_name);
			address = (TextView) row.findViewById(R.id.row_address);
			 icon = (ImageView) row.findViewById(R.id.row_icon);
			 
			 Restaurant r = getItem(position);
			name.setText(r.getName());
			address.setText(r.getAddress());
			
			if(r.getType().equals("sit_down")){
				icon.setImageResource(R.drawable.sitdown);
			}
			else if(r.getType().equals("take_out")){
				icon.setImageResource(R.drawable.takeout);
			}
			else{
				icon.setImageResource(R.drawable.delivery);
			}
		 return row;
	}
	
	@Override
	public Restaurant getItem(int position) {
		// TODO Auto-generated method stub
		return this.model.get(position);
	}
}
