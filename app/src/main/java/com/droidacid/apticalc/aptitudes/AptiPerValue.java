package com.droidacid.apticalc.aptitudes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class AptiPerValue extends MyActionBar implements
        OnClickListener {

    private EditText etValueNumber;
    private EditText etPercent;
    private TextView tvPercentValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aptipervalue);
        actionBar();
        initialize();
    }

    protected void initialize() {

        etValueNumber = (EditText) findViewById(R.id.et_apti_PercentValue);
        etPercent = (EditText) findViewById(R.id.et_apti_Percent);
        tvPercentValue = (TextView) findViewById(R.id.tv_apti_PercentValue);
        Button calculate = (Button) findViewById(R.id.b_apti_calcPercentValue);
        Button bClear = (Button) findViewById(R.id.bClear);
        calculate.setOnClickListener(this);
        bClear.setOnClickListener(this);

    }

    // Have to replace whole below block by try catch block and use a dialog box

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_apti_calcPercentValue:
                try {

                    Double value = Double.parseDouble(etValueNumber.getText()
                            .toString());
                    Double percent = Double.parseDouble(etPercent.getText()
                            .toString());
                    String valueresult = percent + "% of " + value + " is "
                            + (Double.toString((percent * value) / 100));

                    tvPercentValue.setText(valueresult);
                } catch (NumberFormatException e) {
                    // A Dialog Box here to display to enter an input
                    tvPercentValue.setText("");
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
                etPercent.setText("");
                etValueNumber.setText("");
                tvPercentValue.setText("");
                break;
        }
    }
}