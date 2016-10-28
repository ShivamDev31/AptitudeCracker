package com.droidacid.apticalc.aptitudes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.droidacid.apticalc.R;
import com.droidacid.apticalc.common.BaseActivity;
import com.droidacid.apticalc.common.CommonUtils;

public class AptitudeActivity extends BaseActivity implements View.OnClickListener {

    private Button bnumsys;
    private Button bpercent;
    private Button btimenwork;
    private Button btimedist;
    private Button binterest;
    private Button blcmhcf;
    private Button bfactorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    @Override
    public int getLayout() {
        return R.layout.apticalc;
    }

    private void initialize() {
        bnumsys = (Button) findViewById(R.id.b_apti_numsys);
        bpercent = (Button) findViewById(R.id.b_apti_percent);
        btimenwork = (Button) findViewById(R.id.b_apti_timenwork);
        btimedist = (Button) findViewById(R.id.b_apti_timendist);
        binterest = (Button) findViewById(R.id.b_apti_interest);
        blcmhcf = (Button) findViewById(R.id.b_apti_blcmhcf);
        bfactorial = (Button) findViewById(R.id.b_apti_factorial);

        bnumsys.setOnClickListener(this);
        bpercent.setOnClickListener(this);
        btimenwork.setOnClickListener(this);
        btimedist.setOnClickListener(this);
        binterest.setOnClickListener(this);
        blcmhcf.setOnClickListener(this);
        bfactorial.setOnClickListener(this);

    }

    @Override
    public void onClick(View button) {
        switch (button.getId()) {
            case R.id.b_apti_numsys:
                CommonUtils.startActivity(this, NumberSystemActivity.class);
                break;
            case R.id.b_apti_percent:
                CommonUtils.startActivity(this, PercentageActivity.class);
                break;
            case R.id.b_apti_timenwork:
                CommonUtils.startActivity(this, TimeAndWorkActivity.class);
                break;
            case R.id.b_apti_timendist:
                CommonUtils.startActivity(this, TimeAndDistanceActivity.class);
                break;
            case R.id.b_apti_interest:
                CommonUtils.startActivity(this, InterestActivity.class);
                break;
            case R.id.b_apti_blcmhcf:
                CommonUtils.startActivity(this, LcmHcfActivity.class);
                break;
            case R.id.b_apti_factorial:
                CommonUtils.startActivity(this, FactorialActivity.class);
                break;
        }
    }
}