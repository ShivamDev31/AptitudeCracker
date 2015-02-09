package com.droidacid.apticalc.aptitudes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class AptiTimeNWork extends MyActionBar implements OnClickListener,
		OnCheckedChangeListener {

	TextView tvOutput;
	RadioGroup rgSelect;
	EditText num1, num2, num3;
	Button calculate, bClear;
	RadioButton rbTtwo, rbThree;
	Double numb1, numb2, numb3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aptitimenwork);
		actionBar();
		initialize();
	}

	private void initialize() {

		tvOutput = (TextView) findViewById(R.id.tv_apti_result);
		rgSelect = (RadioGroup) findViewById(R.id.rg_apti_Select);

		num1 = (EditText) findViewById(R.id.et_apti_firstperson);
		num2 = (EditText) findViewById(R.id.et_apti_secondperson);
		num3 = (EditText) findViewById(R.id.et_apti_thirdperson);

		calculate = (Button) findViewById(R.id.b_apti_calcWD);
		bClear = (Button) findViewById(R.id.bClear);
		bClear.setOnClickListener(this);
		calculate.setOnClickListener(this);
		rgSelect.setOnCheckedChangeListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b_apti_calcWD:
			int selectedRB = rgSelect.getCheckedRadioButtonId();

			if (this.num3.getText().toString().equals(""))
				num3.setText("0");
			Double numb3 = Double.parseDouble(num3.getText().toString());
			try {
				Double numb1 = Double.parseDouble(num1.getText().toString());
				Double numb2 = Double.parseDouble(num2.getText().toString());

				switch (selectedRB) {
				case R.id.rb_apti_twoperson:
					tvOutput.setText("Time taken = "
							+ Double.toString(100 / (100 / numb1 + 100 / numb2))
							+ " days");
					break;
				case R.id.rb_apti_threeperson:
					tvOutput.setText("Time taken = "
							+ Double.toString(100 / (100 / numb1 + 100 / numb2 + 100 / numb3))
							+ " days");
					break;
				}
			} catch (NumberFormatException e) {
				// A Dialog Box here to display to enter an input
				tvOutput.setText("");
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
			num1.setText("");
			num2.setText("");
			num3.setText("");
			tvOutput.setText("");
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {

		switch (arg1) {
		case R.id.rb_apti_twoperson:
			num3.setVisibility(View.GONE);

			break;
		case R.id.rb_apti_threeperson:
			num3.setVisibility(View.VISIBLE);
			break;
		}
	}
}