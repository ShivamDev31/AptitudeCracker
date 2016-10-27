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

public class AptiNumSys extends MyActionBar implements OnClickListener {
    private Button bClear;
    private TextView output;
    private EditText number1;
    private EditText number2;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar();
        setContentView(R.layout.aptinumsys);
        initialize();

        clear();
    }

    private void initialize() {
        // Reference TextViews and Buttons
        number1 = (EditText) findViewById(R.id.et_apti_number1);
        number2 = (EditText) findViewById(R.id.et_apti_number2);
        output = (TextView) findViewById(R.id.tv_apti_output);
        Button add = (Button) findViewById(R.id.b_apti_add);
        Button subtract = (Button) findViewById(R.id.b_apti_sub);
        Button multiply = (Button) findViewById(R.id.b_apti_mul);
        Button divide = (Button) findViewById(R.id.b_apti_div);
        Button mod = (Button) findViewById(R.id.b_apti_mod);
        bClear = (Button) findViewById(R.id.bClear);

        // Set listeners for when buttons are pressed
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        mod.setOnClickListener(this);

    }

    /**
     * Switch statement to decide which button was pressed
     */
    public void onClick(View v) {

        // Get values from top two TextViews

        try {
            // If the values are blank set them to 0
            double numberone = Double.parseDouble(this.number1.getText()
                    .toString());
            double numbertwo = Double.parseDouble(this.number2.getText()
                    .toString());
            this.output.setText("");

            // Initialize output
            double outputValue = 0;

            // Perform relevant operations
            switch (v.getId()) {
                case R.id.b_apti_add:
                    outputValue = numberone + numbertwo;
                    break;
                case R.id.b_apti_sub:
                    outputValue = numberone - numbertwo;
                    break;
                case R.id.b_apti_mul:
                    outputValue = numberone * numbertwo;
                    break;
                case R.id.b_apti_div:
                    outputValue = numberone / numbertwo;
                    break;
                case R.id.b_apti_mod:
                    outputValue = numberone % numbertwo;
                    break;
            }
            String result = "Answer is : " + outputValue;

            output.setText(result);

        } catch (Exception e) {
            // A Dialog Box here to display to enter an input
            output.setText("");
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

    private void clear() {
        bClear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                output.setText("");
                number1.setText("");
                number2.setText("");
            }
        });
    }
}