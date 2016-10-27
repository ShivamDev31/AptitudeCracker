package com.droidacid.apticalc.aptitudes;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

    private EditText etTime;
    private EditText etDistance;
    private EditText etSpeed;
    private TextView tvResult;
    private RadioGroup rgTimeDist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aptitimedist);
        actionBar();
        initialize();
    }

    private void initialize() {
        Button bCalc = (Button) findViewById(R.id.b_apti_CalcTDS);
        etTime = (EditText) findViewById(R.id.et_apti_Time);
        etSpeed = (EditText) findViewById(R.id.et_apti_Speed);
        etDistance = (EditText) findViewById(R.id.et_apti_distance);
        tvResult = (TextView) findViewById(R.id.tv_apti_Result);
        rgTimeDist = (RadioGroup) findViewById(R.id.rg_apti_TimeDist);
        rgTimeDist.setOnCheckedChangeListener(this);
        Button bClear = (Button) findViewById(R.id.bClear);
        bClear.setOnClickListener(this);
        bCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_apti_CalcTDS:
                int selectedRB = rgTimeDist.getCheckedRadioButtonId();

                switch (selectedRB) {
                    case R.id.rb_apti_Time:
                        Double speed;
                        Double dist;
                        try {
                            speed = Double.parseDouble(etSpeed.getText().toString());
                            dist = Double.parseDouble(etDistance.getText().toString());
                            tvResult.setText("Time taken = " + Double.toString(dist / speed) + " hrs");
                        } catch (NumberFormatException e) {
                            showDialog();
                        }
                        break;

                    case R.id.rb_apti_Speed:
                        Double time;
                        try {
                            time = Double.parseDouble(etTime.getText().toString());
                            dist = Double.parseDouble(etDistance.getText().toString());
                            tvResult.setText("Speed = " + Double.toString(dist / time) + " km/hr");

                        } catch (NumberFormatException e) {
                            showDialog();
                        }
                        break;

                    case R.id.rb_apti_Distance:
                        try {
                            time = Double.parseDouble(etTime.getText().toString());
                            speed = Double.parseDouble(etSpeed.getText().toString());
                            tvResult.setText("Distance = " + Double.toString(speed * time) + " km");
                        } catch (NumberFormatException e) {
                            showDialog();
                        }
                        break;
                }
                break;

            case R.id.bClear:
                etSpeed.setText("");
                etTime.setText("");
                etDistance.setText("");
                tvResult.setText("");
                break;
        }

    }

    private void showDialog() {

        // A Dialog Box here to display to enter an input
        tvResult.setText("");
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

    @Override
    public void onCheckedChanged(RadioGroup RgTimeDist, int TimeDist) {

        switch (TimeDist) {

            case R.id.rb_apti_Time:
                etTime.setVisibility(View.GONE);
                etSpeed.setVisibility(View.VISIBLE);
                etDistance.setVisibility(View.VISIBLE);
                etSpeed.setText("");
                etDistance.setText("");
                tvResult.setText("");
                break;
            case R.id.rb_apti_Speed:
                etSpeed.setVisibility(View.GONE);
                etTime.setVisibility(View.VISIBLE);
                etDistance.setVisibility(View.VISIBLE);
                etTime.setText("");
                etDistance.setText("");
                tvResult.setText("");
                break;
            case R.id.rb_apti_Distance:
                etDistance.setVisibility(View.GONE);
                etSpeed.setVisibility(View.VISIBLE);
                etTime.setVisibility(View.VISIBLE);
                etSpeed.setText("");
                etTime.setText("");
                tvResult.setText("");
                break;
        }
    }
}
