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

public class AptiFactorial extends MyActionBar implements
        android.view.View.OnClickListener {
    EditText number;
    TextView answer;
    Button calculate, bClear;
    double factorial = 1;
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar();
        setContentView(R.layout.apti_factorial);
        initialize();

    }

    private void initialize() {
        number = (EditText) findViewById(R.id.et_apti_number);
        answer = (TextView) findViewById(R.id.tv_apti_answer);
        calculate = (Button) findViewById(R.id.b_fact_calc);
        bClear = (Button) findViewById(R.id.bClear);

        calculate.setOnClickListener(this);
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
                /*for (int i = num; i <= 1; i--) {
					factorial *= i;
				}*/

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
