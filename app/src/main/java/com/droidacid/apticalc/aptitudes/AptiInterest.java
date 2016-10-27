package com.droidacid.apticalc.aptitudes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

/**
 * Created by ShivamD on 5/19/13.
 */
public class AptiInterest extends MyActionBar implements View.OnClickListener {
	private static final String TAG = AptiInterest.class.getSimpleName();
	private EditText etPrincipal;
	private EditText etRate;
	private EditText etTime;
	private Button calcSI;
	private Button calcCI;
	private Button bClear;;
	private TextView tvAnswer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aptiinterest);
		actionBar();
		initialize();
	}

	private void initialize() {

		etPrincipal = (EditText) findViewById(R.id.et_apti_Principal);
		etRate = (EditText) findViewById(R.id.et_apti_Rate);
		etTime = (EditText) findViewById(R.id.et_apti_Time);
		calcSI = (Button) findViewById(R.id.b_apti_CalcSimpleInt);
		calcCI = (Button) findViewById(R.id.b_apti_CalcCompoundInt);
		tvAnswer = (TextView) findViewById(R.id.tv_apti_Answer);
		bClear = (Button) findViewById(R.id.bClear);
		calcSI.setOnClickListener(this);
		calcCI.setOnClickListener(this);
		bClear.setOnClickListener(this);

	}

	// Have to replace whole below block by try catch block and use a dialog box

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.b_apti_CalcSimpleInt:
			try {
				Double principal = Double.parseDouble(etPrincipal.getText()
						.toString());
				Double rate = Double.parseDouble(etRate.getText().toString());
				Double time = Double.parseDouble(etTime.getText().toString());

				String result = "Simple interest is: "
						+ ((principal * rate * time) / 100);
				tvAnswer.setText(result);
			} catch (NumberFormatException e) {
				// A Dialog Box here to display to enter an input
				tvAnswer.setText("");
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
		case R.id.b_apti_CalcCompoundInt:
			try {
				Double principal = Double.parseDouble(etPrincipal.getText()
						.toString());
				Double rate = Double.parseDouble(etRate.getText().toString());
				Double time = Double.parseDouble(etTime.getText().toString());

				String result = "Compound interest is: "
						+ ((principal) * Math.pow((1 + (rate / 100)), time));
				tvAnswer.setText(result);
			} catch (NumberFormatException e) {
				// A Dialog Box here to display to enter an input
				tvAnswer.setText("");
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
		case R.id.bClear:
			etPrincipal.setText("");
			etRate.setText("");
			etTime.setText("");
			tvAnswer.setText("");
			break;
		}
	}
}
