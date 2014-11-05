package com.example.combiningtablayoutandlistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class InboxListViewAdapter extends ArrayAdapter<InboxListItems>{
	Context context;
	final ArrayList<InboxListItems> inboxList;
	int layout;
	
	public InboxListViewAdapter(Context context, int layout, ArrayList<InboxListItems> inboxList) {
		super(context, layout, inboxList);
		this.context = context;
		this.layout = layout;
		this.inboxList = inboxList;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rootView = convertView;
		
		if(rootView == null){
			LayoutInflater view = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rootView = view.inflate(this.layout, null);
		}
		TextView txtFrom = (TextView)rootView.findViewById(R.id.from);
		TextView txtSubject = (TextView)rootView.findViewById(R.id.subject);
		TextView txtDate = (TextView)rootView.findViewById(R.id.date);
		
		final InboxListItems m = getItem(position);
		txtFrom.setText(m.getFrom());
		txtSubject.setText(m.getSubject());
		txtDate.setText(m.getDate());
		
		return rootView;
	}
	
	@Override
	public InboxListItems getItem(int position) {
		// TODO Auto-generated method stub
		return this.inboxList.get(position);
	}
	
}
