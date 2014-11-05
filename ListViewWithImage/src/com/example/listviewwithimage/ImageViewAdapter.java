package com.example.listviewwithimage;
import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ImageViewAdapter extends ArrayAdapter<ImageItem>{
	Context context;
	ArrayList<ImageItem> data;
	int layout;

	public ImageViewAdapter(Context context, int layout,ArrayList<ImageItem> objects) {
		super(context, layout, objects);
		this.context = context;
		this.data = objects;
		this.layout = layout;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rootView  = convertView;
		
		if(rootView == null){
			LayoutInflater view = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rootView = view.inflate(this.layout, null);
		}
		
		ImageButton img = (ImageButton)rootView.findViewById(R.id.imageView);
		TextView companyName = (TextView)rootView.findViewById(R.id.companyName);
		TextView address = (TextView)rootView.findViewById(R.id.address);
		
		ImageItem m = getItem(position);
		companyName.setText(m.getCompanyName());
		Log.i("test", m.getCompanyName());
		address.setText(m.getAddress());
		img.setImageResource(m.getImage());
		
		img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final ProgressDialog pd = new ProgressDialog(context);
				pd.setMessage("This is a progress Dialog");
				pd.setCancelable(true);
				pd.show();
				
				final Thread thread= new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							Thread.sleep(1000);
							pd.dismiss();
							Intent i = new Intent(context, ImageListView.class);
							context.startActivity(i);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				});
				thread.start();
				
			}
		});
		
		return rootView;
	}
	
	public ImageItem getItem(int index){
		return this.data.get(index);
	}

}