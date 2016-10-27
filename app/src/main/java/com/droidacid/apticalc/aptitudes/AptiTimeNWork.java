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

public class AptiTimeNWork extends MyActionBar implements OnClickListener,
        OnCheckedChangeListener {

    private TextView tvOutput;
    private RadioGroup rgSelect;
    private EditText num1;
    private EditText num2;
    private EditText num3;
    private Double numb1;
    private Double numb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        Button calculate = (Button) findViewById(R.id.b_apti_calcWD);
        Button bClear = (Button) findViewById(R.id.bClear);
        bClear.setOnClickListener(this);
        calculate.setOnClickListener(this);
        rgSelect.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_apti_calcWD:
                int selectedRB = rgSelect.getCheckedRadioButtonId();


                switch (selectedRB) {
                    case R.id.rb_apti_twoperson:
                        try {
                            numb1 = Double.parseDouble(num1.getText().toString());
                            numb2 = Double.parseDouble(num2.getText().toString());
                            tvOutput.setText("Time taken = " + Double.toString(100 / (100 / numb1 + 100 / numb2)) + " days");
                        } catch (NumberFormatException e) {
                            showDialog();
                        }

                        break;
                    case R.id.rb_apti_threeperson:

                        try {
                            Double numb3 = Double.parseDouble(num3.getText().toString());
                            tvOutput.setText("Time taken = " + Double.toString(100 / (100 / numb1 + 100 / numb2 + 100 / numb3)) + " days");
                        } catch (NumberFormatException e) {
                            showDialog();
                            break;
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
    }

    private void showDialog() {
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

    @Override
    public void onCheckedChanged(RadioGroup arg0, int arg1) {

        switch (arg1) {
            case R.id.rb_apti_twoperson:
                num3.setVisibility(View.GONE);
                num1.setText("");
                num2.setText("");
                tvOutput.setText("");
                break;
            case R.id.rb_apti_threeperson:
                num3.setVisibility(View.VISIBLE);
                num1.setText("");
                num2.setText("");
                num3.setText("");
                tvOutput.setText("");
                break;
        }
    }
}
