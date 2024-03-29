package com.simpumind.estatemanagement;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	Button btnLogin;
	Button btnReg;
	Button btnCancel;
	
	EditText username;
	EditText password;
	
	private ProgressDialog pDailog;
	JSONParser jsonparser = new JSONParser();
	
	private static final String LOGIN_URL = "http://172.16.3.82/Estate_Conny/login.php";
	
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_MESSAGE = "message";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnLogin = (Button)findViewById(R.id.btnlogin);
		btnReg = (Button)findViewById(R.id.btncreate);
		btnCancel = (Button)findViewById(R.id.btnquit);
		
		username = (EditText)findViewById(R.id.inputname);
		password = (EditText)findViewById(R.id.inputpassword);
		
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new AttemptLogin().execute();
			}
		});
		btnReg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), RegActivity.class);
				startActivity(i);
			}
		});
		btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
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
	
	public class AttemptLogin extends AsyncTask<String, String, String>{
		
		boolean failure = false;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDailog = new ProgressDialog(MainActivity.this);
			pDailog.setMessage("Login in user...");
			pDailog.setIndeterminate(false);
			pDailog.setCancelable(true);
			pDailog.show();
		}
		
		@Override
		protected String doInBackground(String... args) {
			int success;
			String user = username.getText().toString();
			String pass = password.getText().toString();
			try{
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("username", user));
				params.add(new BasicNameValuePair("password", pass));
				
				Log.d("Request", "starting");
				//Get product details by making HTTP request
				JSONObject json = jsonparser.makeHttpRequest(LOGIN_URL, "POST", params);
				//Check your log for json response
				Log.d("Login attempt", json.toString());
				
				//json success tag
				success = json.getInt(TAG_SUCCESS);
				if(success == 1){
					Log.d("Login Successful!", json.toString());
					Intent i = new Intent(MainActivity.this, ScreenActivity.class);
					finish();
					startActivity(i);
					return json.getString(TAG_MESSAGE);
				}
				else{
					Log.d("Login failure!", json.getString(TAG_MESSAGE));
					return json.getString(TAG_MESSAGE);
				}
			}
			catch(JSONException e){
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			pDailog.dismiss();
			if(result != null){
				Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
			}
		}
		
	}
}
