package com.droidacid.apticalc.aptitudes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.droidacid.apticalc.common.BaseActivity;
import com.droidacid.apticalc.R;

public class FactorialActivity extends BaseActivity implements
        android.view.View.OnClickListener {
    private EditText number;
    private TextView answer;
    private Button bCalculate;
    private Button bClear;
    private double factorial = 1;
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    @Override
    public int getLayout() {
        return R.layout.apti_factorial;
    }

    private void initialize() {
        number = (EditText) findViewById(R.id.et_apti_number);
        answer = (TextView) findViewById(R.id.tv_apti_answer);
        bCalculate = (Button) findViewById(R.id.b_fact_calc);
        bClear = (Button) findViewById(R.id.bClear);

        bCalculate.setOnClickListener(this);
        bClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_fact_calc:
                calcFactorial();
                break;
            case R.id.bClear:
                number.setText("");
                answer.setText("");
        }
    }

    private void calcFactorial() {
        try {
            num = Integer.parseInt(number.getText().toString());

            if (num < 25) {
                for (int c = 1; c <= num; c++)
                    factorial = factorial * c;
                answer.setText("Factorial of " + num + " is : " + factorial);
                factorial = 1;

            } else {
                // A Dialog Box here to display to enter an input
                answer.setText("");
                AlertDialog.Builder d = new AlertDialog.Builder(this);
                d.setTitle("Large value entered");
                d.setMessage("Please enter value less than 25");
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
        } catch (NumberFormatException e) {
            // A Dialog Box here to display to enter an input
            answer.setText("");
            AlertDialog.Builder d = new AlertDialog.Builder(this);
            d.setTitle("No value entered");
            d.setMessage("Fields cannot be left blank");
            d.setNegativeButton("Ok", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            d.show();
        }
    }
}
