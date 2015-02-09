package com.droidacid.apticalc.aptitudes;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class AptiTimeDist extends MyActionBar implements OnClickListener,
		OnCheckedChangeListener {

	Button bCalc, bClear;
	EditText etTime, etDistance, etSpeed;
	TextView tvResult;
	RadioGroup rgTimeDist;
	String tag = "Time Speed Distance";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aptitimedist);
		actionBar();
		initialize();
	}

	private void initialize() {
		bCalc = (Button) findViewById(R.id.b_apti_CalcTDS);
		etTime = (EditText) findViewById(R.id.et_apti_Time);
		etSpeed = (EditText) findViewById(R.id.et_apti_Speed);
		etDistance = (EditText) findViewById(R.id.et_apti_distance);
		tvResult = (TextView) findViewById(R.id.tv_apti_Result);
		rgTimeDist = (RadioGroup) findViewById(R.id.rg_apti_TimeDist);
		rgTimeDist.setOnCheckedChangeListener(this);
		bClear = (Button) findViewById(R.id.bClear);
		bClear.setOnClickListener(this);
		bCalc.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b_apti_CalcTDS:
			int selectedRB = rgTimeDist.getCheckedRadioButtonId();

			if (etTime.getText().toString().equals(""))
				etTime.setText("0");
			tvResult.setText("");
			if (etSpeed.getText().toString().equals(""))
				etSpeed.setText("0");
			tvResult.setText("");
			if (etDistance.getText().toString().equals(""))
				etDistance.setText("0");
			tvResult.setText("");

			Double Time = Double.parseDouble(etTime.getText().toString());
			Double Speed = Double.parseDouble(etSpeed.getText().toString());
			Double Dist = Double.parseDouble(etDistance.getText().toString());

			switch (selectedRB) {
			case R.id.rb_apti_Time:
				tvResult.setText("Time taken = "
						+ Double.toString(Dist / Speed) + " hrs");

				break;

			case R.id.rb_apti_Speed:
				tvResult.setText("Speed = " + Double.toString(Dist / Time)
						+ " km/hr");

				break;

			case R.id.rb_apti_Distance:
				tvResult.setText("Distance = " + Double.toString(Speed * Time)
						+ " km");

				break;
			}
			break;
		case R.id.bClear:
			etTime.setText("");
			etSpeed.setText("");
			etDistance.setText("");
			tvResult.setText("");
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup RgTimeDist, int TimeDist) {

		switch (TimeDist) {

		case R.id.rb_apti_Time:
			etTime.setVisibility(View.GONE);
			etSpeed.setVisibility(View.VISIBLE);
			etDistance.setVisibility(View.VISIBLE);

			break;
		case R.id.rb_apti_Speed:
			etSpeed.setVisibility(View.GONE);
			etTime.setVisibility(View.VISIBLE);
			etDistance.setVisibility(View.VISIBLE);

			break;
		case R.id.rb_apti_Distance:
			etDistance.setVisibility(View.GONE);
			etSpeed.setVisibility(View.VISIBLE);
			etTime.setVisibility(View.VISIBLE);

			break;
		}
	}
}
