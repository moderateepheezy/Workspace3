package com.example.examplefragments;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	Button switchFragment;
	int state = 0;
	//ActionBar abar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		//abar = getSupportActionBar();

		//switchFragment = (Button)this.findViewById(R.id.changeFragment);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
			.add(R.id.container, new TestFragment()).commit();
			//state = 1;
		}

//		switchFragment.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				if(state == 1){
//
//					FragmentTransaction fTrag = getSupportFragmentManager().beginTransaction();
//
//					fTrag.replace(R.id.container, new NewFragment());
//
//					fTrag.commit();
//
//					abar = getSupportActionBar();
//					abar.setTitle("ActionBar for New Fragment");
//					state = 0;
//				}else{
//
//					FragmentTransaction fTrag = getSupportFragmentManager().beginTransaction();
//
//					fTrag.replace(R.id.container, new PlaceholderFragment());
//
//					fTrag.commit();
//
//					abar = getSupportActionBar();
//					abar.setTitle("ActionBar for PlaceHolderFragment");
//					state = 1;
//				}
//			}
//		});





	}
}
