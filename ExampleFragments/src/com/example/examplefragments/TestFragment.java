
package com.example.examplefragments;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * @author Akapo Damilola F. [ helios66, fdamilola ]
 *
 * 
 */

public class TestFragment extends Fragment {

	Button showAlertDialog, showProgressDialog;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_main, container, false);

		final Button showAlertDialog = (Button)view.findViewById(R.id.showAlertDialog);
		final Button showProgressDialog = (Button)view.findViewById(R.id.showProgressDialog);
		
		showAlertDialog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final AlertDialog.Builder alertDiag = new AlertDialog.Builder(getActivity());
				alertDiag.setMessage("This is an alert dialog.");
				alertDiag.setNeutralButton("Cancel", null);
				alertDiag.create().show();
			}
		});

		showProgressDialog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final ProgressDialog pDiag = new ProgressDialog(getActivity());
				pDiag.setMessage("This is a progress dialog");
				pDiag.setCancelable(true);
				pDiag.setCanceledOnTouchOutside(true);
				pDiag.show();
			}
		});
		
		return view;
	}


	

}

