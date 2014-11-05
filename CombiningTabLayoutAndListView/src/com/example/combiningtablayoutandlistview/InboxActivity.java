package com.example.combiningtablayoutandlistview;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.codecamp.libs.RestClient;
import com.codecamp.libs.RestClient.RequestMethod;

public class InboxActivity extends ActionBarActivity {
	ProgressDialog pDialog;
	ArrayList<InboxListItems> inboxList = new ArrayList<InboxListItems>();
	InboxListViewAdapter adapter;
	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inbox_list);
		listView = (ListView)findViewById(R.id.list);
		adapter = new InboxListViewAdapter(getApplicationContext(), R.layout.inbox_list_items, inboxList);
		listView.setAdapter(adapter);
		
		new LoadInbox().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inbox, menu);
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
	
	public class LoadInbox extends AsyncTask<String, String, String>{
		private RestClient connect;
		private String text;
		ArrayList<String> data;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pDialog = new ProgressDialog(InboxActivity.this);
			pDialog.setMessage("Loading Inbox ...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}
		@Override
		protected String doInBackground(String... arg0) {
			final String INBOX_URL = "http://api.androidhive.info/mail/inbox.json";
			connect = new RestClient(INBOX_URL);
			Log.d("TAG", "I'm about to make a request to: " + INBOX_URL);
			
			try {
				connect.Execute(RequestMethod.GET);
				text = connect.getResponse();
				JSONObject object  =new JSONObject(text);
				//object.get("")
				JSONArray dataObject = object.getJSONArray("message");
				for(int i = 0; i < dataObject.length(); i++){
					MusicJSON in = new MusicJSON((JSONObject)dataObject.get(i));
					
					inboxList.
					add(new InboxListItems(in.getFrom(), in.getDate(), 
							in.getSubject()));
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
			adapter = new InboxListViewAdapter(getApplicationContext(), R.layout.inbox_list_items, inboxList);
			adapter.notifyDataSetChanged();
			listView.setAdapter(adapter);
			pDialog.dismiss();
		}
		
	}
}
