package com.droidacid.apticalc.aptitudes;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.droidacid.apticalc.R;
import com.droidacid.apticalc.common.BaseActivity;

public class PercentageValueActivity extends BaseActivity implements
        OnClickListener {

    private EditText etValueNumber;
    private EditText etPercent;
    private TextView tvPercentValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    @Override
    public int getLayout() {
        return R.layout.aptipervalue;
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
                            (dialog, which) -> dialog.cancel());

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