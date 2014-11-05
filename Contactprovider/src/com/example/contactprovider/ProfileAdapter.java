package com.example.contactprovider;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.contactprovider.data.*;
public class ProfileAdapter extends ArrayAdapter<Pair> {
	private static String TAG = ProfileAdapter.class.getSimpleName();
	private LayoutInflater inflater = null;
	List<Pair> pairList = null;
	private Context context;
	private int layout;

	public ProfileAdapter(Context context, int resource,
			int textViewResourceId, List<Pair> objects) {
		super(context, resource, textViewResourceId, objects);
		this.pairList = objects;
	}

	public void setInflater(LayoutInflater inflater) {
		this.inflater = inflater;
	}

	public void setLayout(int layout) {
		this.layout = layout;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rootView = convertView;
		if (convertView == null) {
			LayoutInflater view = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rootView = view.inflate(this.layout, null);
		}
		TextView  key = (TextView)rootView.findViewById(R.id.key);
		TextView  value = (TextView)rootView.findViewById(R.id.value);
		
		Pair pair = (Pair)getItem(position);
		String keys = pair.key;
		String  values = pair.value;
		key.setText(keys);
		value.setText(values);
		
		return rootView;
	}
	
	@Override
	public long getItemId(int position) {
		return 1;
	}
	@Override
	public int getCount() {
		return pairList.size();
	}
	
	@Override
	public Pair getItem(int position) {
		// TODO Auto-generated method stub
		return (Pair)super.getItem(position);
	}
	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return super.getItemViewType(position);
	}
	
	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return super.getViewTypeCount();
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return super.isEmpty();
	}
}
