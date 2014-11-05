package com.simpumind.estatemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ScreenActivity extends ActionBarActivity {
	Button btnView;
	Button btnNew;
	Button btnLogout;
	Button btncontact;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen);
		
		btnView = (Button)findViewById(R.id.btnViewProducts);
		btnNew = (Button)findViewById(R.id.btnNew);
		btnLogout = (Button)findViewById(R.id.btnlogout);
		btncontact = (Button)findViewById(R.id.btnContact);
		
		// view products click event
				btnView.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View view) {
						// Launching All products Activity
						
						finish();
						Intent i = new Intent(getApplicationContext(), ReadComments.class);
						startActivity(i);
						
					}
				});
				
				btnNew.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View view) {
						// Launching All products Activity
						
						finish();
						Intent i = new Intent(getApplicationContext(), AddProperty.class);
						startActivity(i);
						
					}
				});
				
				// view products click event
				
				
		           btncontact.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View view) {
						
						finish();
						// Launching create new product activity
						Intent i = new Intent(getApplicationContext(), MessageActivity.class);
						startActivity(i);
						
					}
				});
				
		btnLogout.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View view) {
						// Launching create new product activity
						finish();
						Intent i = new Intent(getApplicationContext(), MainActivity.class);
						startActivity(i);
						
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.screen, menu);
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
