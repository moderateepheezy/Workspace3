package com.example.combiningtablayoutandlistview;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
	private static final String INBOX_SPEC = "Inbox";
	private static final String OUTPUT_SPEC = "Output";
	private static final String PROFILE_SPEC = "Profile";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabHost tabHost = getTabHost();
		
		//Inbox tab
		TabSpec inboxSpec = tabHost.newTabSpec(INBOX_SPEC);
		//Tab Icon
		inboxSpec.setIndicator(INBOX_SPEC, getResources().getDrawable(R.drawable.icon_inbox));
		Intent inboxIntent = new Intent(this, InboxActivity.class);
		//Tab Content
		inboxSpec.setContent(inboxIntent);
		
		//Outbox Tab
		TabSpec outboxSpec = tabHost.newTabSpec(OUTPUT_SPEC);
		outboxSpec.setIndicator(OUTPUT_SPEC, getResources().getDrawable(R.drawable.icon_outbox));
		Intent outboxIntent = new Intent(this, OutboxActivity.class);
		//Tab Content
		outboxSpec.setContent(outboxIntent);
		
		//Profile Tab
		TabSpec profileSpec = tabHost.newTabSpec(PROFILE_SPEC);
		profileSpec.setIndicator(PROFILE_SPEC,getResources().getDrawable(R.drawable.icon_profile));
		Intent profileIntent = new Intent(this, ProfileActivity.class);
		//Tab Content
		profileSpec.setContent(profileIntent);
		
		tabHost.addTab(profileSpec);
		tabHost.addTab(outboxSpec);
		tabHost.addTab(inboxSpec);
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
}
