package com.example.smsmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.telephony.gsm.SmsManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSManager extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_smsmanager);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.smsmanager, menu);
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
		Button btnSend;
		EditText phoneNum;
		EditText textMessage;
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_smsmanager,
					container, false);
			btnSend = (Button)rootView.findViewById(R.id.buttonSend);
			textMessage = (EditText)rootView.findViewById(R.id.editTextSMS);
			phoneNum = (EditText)rootView.findViewById(R.id.EditTextNumber);
			
			btnSend.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					String phoneNumber = phoneNum.getText().toString();
					String 	message = textMessage.getText().toString();
					
					try{
						SmsManager smsManager = SmsManager.getDefault();
						smsManager.sendTextMessage(phoneNumber, null, message, null, null);
						Toast.makeText(getActivity(), "Message Sent!...", Toast.LENGTH_SHORT).show();
					}
					catch(Exception e){
						Toast.makeText(getActivity(), "Sms failed please try again...", Toast.LENGTH_SHORT).show();
						e.printStackTrace();
					}
				}
			});
			return rootView;
		}
	}
}
