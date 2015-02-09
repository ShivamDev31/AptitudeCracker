package com.droidacid.apticalc.aptitudes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class AptiPercent extends MyActionBar implements
		android.view.View.OnClickListener {

	EditText numerator, denominator;
	Button bpercent, percentvalue, bClear;
	TextView output;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aptipercent);
		actionBar();
		initialize();

	}

	private void initialize() {
		numerator = (EditText) findViewById(R.id.et_apti_numerator);
		denominator = (EditText) findViewById(R.id.et_apti_denominator);
		bpercent = (Button) findViewById(R.id.b_apti_calcPercent);
		output = (TextView) findViewById(R.id.tv_apti_output);
		percentvalue = (Button) findViewById(R.id.b_apti_calcValue);
		bClear = (Button) findViewById(R.id.bClear);
		bpercent.setOnClickListener(this);
		percentvalue.setOnClickListener(this);
		bClear.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.b_apti_calcPercent:
			// Parse the input values to num and den as double

			try {
				Double num = Double.parseDouble(numerator.getText().toString());
				Double den = Double.parseDouble(denominator.getText()
						.toString());
				String result = num + " is "
						+ (Double.toString((num / den) * 100)) + " % of " + den;
				output.setText(result);
			} catch (NumberFormatException e) {
				// A Dialog Box here to display to enter an input
				output.setText("");
				AlertDialog.Builder d = new AlertDialog.Builder(this);
				d.setTitle("No value entered");
				d.setMessage("Fields cannot be left blank");
				d.setNegativeButton("Ok",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.cancel();
							}
						});

				d.show();
			}
			break;
		case R.id.b_apti_calcValue:
			Intent PercentValue = new Intent(this, AptiPerValue.class);
			startActivity(PercentValue);
			break;
		case R.id.bClear:
			numerator.setText("");
			denominator.setText("");
			output.setText("");
			break;
		}

	}

}
