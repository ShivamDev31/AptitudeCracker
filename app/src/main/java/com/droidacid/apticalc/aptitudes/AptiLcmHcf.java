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

/**
 * Created by ShivamD on 5/18/13.
 */
public class AptiLcmHcf extends MyActionBar implements OnClickListener {

    private Button bCalc;
    private Button bClear;
    private EditText etNumber1;
    private EditText etNumber2;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aptilcmhcf);
        actionBar();
        initialize();
    }

    protected void initialize() {

        etNumber1 = (EditText) findViewById(R.id.et_apti_Num1);
        etNumber2 = (EditText) findViewById(R.id.et_apti_Num2);

        tvResult = (TextView) findViewById(R.id.tv_apti_LcmResult);
        bCalc = (Button) findViewById(R.id.b_apti_Lcm);
        bClear = (Button) findViewById(R.id.bClear);
        bCalc.setOnClickListener(this);
        bClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_apti_Lcm:
                try {
                    int numb1 = Integer.parseInt(etNumber1.getText().toString());
                    int numb2 = Integer.parseInt(etNumber2.getText().toString());

                    int hcf = 1;
                    int p = numb1 * numb2;
                    for (int i = 2; i < p; i++) {
                        if ((numb1 % i == 0) && (numb2 % i == 0)) {
                            hcf = i;
                        }
                    }
                    int lcm = p / hcf;
                    String result = "LCM is : " + lcm + " & HCF is : " + hcf;
                    tvResult.setText(result);
                } catch (NumberFormatException e) {
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
                break;
            case R.id.bClear:
                etNumber1.setText("");
                etNumber2.setText("");
                tvResult.setText("");
                break;
        }
    }
}