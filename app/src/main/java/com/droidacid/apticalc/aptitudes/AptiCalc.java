package com.droidacid.apticalc.aptitudes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class AptiCalc extends MyActionBar implements View.OnClickListener {

    Button bnumsys, bpercent, btimenwork, btimedist, binterest, blcmhcf,
            bareavolume, bfactorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar();
        setContentView(R.layout.apticalc);
        initialize();
    }

    private void initialize() {
        bnumsys = (Button) findViewById(R.id.b_apti_numsys);
        bpercent = (Button) findViewById(R.id.b_apti_percent);
        btimenwork = (Button) findViewById(R.id.b_apti_timenwork);
        btimedist = (Button) findViewById(R.id.b_apti_timendist);
        binterest = (Button) findViewById(R.id.b_apti_interest);
        blcmhcf = (Button) findViewById(R.id.b_apti_blcmhcf);
        //bareavolume = (Button) findViewById(R.id.b_apti_geometry);
        bfactorial = (Button) findViewById(R.id.b_apti_factorial);

        bnumsys.setOnClickListener(this);
        bpercent.setOnClickListener(this);
        btimenwork.setOnClickListener(this);
        btimedist.setOnClickListener(this);
        binterest.setOnClickListener(this);
        blcmhcf.setOnClickListener(this);
        //bareavolume.setOnClickListener(this);
        bfactorial.setOnClickListener(this);

    }

    @Override
    public void onClick(View button) {
        // Switch case for buttons

        switch (button.getId()) {
            case R.id.b_apti_numsys:
                Intent NumSys = new Intent(this, AptiNumSys.class);
                startActivity(NumSys);
                break;
            case R.id.b_apti_percent:
                Intent Percentage = new Intent(this, AptiPercent.class);
                startActivity(Percentage);
                break;
            case R.id.b_apti_timenwork:
                Intent TimeNWork = new Intent(this, AptiTimeNWork.class);
                startActivity(TimeNWork);
                break;
            case R.id.b_apti_timendist:
                Intent TimeDist = new Intent(this, AptiTimeDist.class);
                startActivity(TimeDist);
                break;
            case R.id.b_apti_interest:
                Intent Interest = new Intent(this, AptiInterest.class);
                startActivity(Interest);
                break;
            case R.id.b_apti_blcmhcf:
                Intent LCMHCF = new Intent(this, AptiLcmHcf.class);
                startActivity(LCMHCF);
                break;
            /*case R.id.b_apti_geometry:
                Intent AreaVolume = new Intent(this, AptiGeometry.class);
                startActivity(AreaVolume);
                break;*/
            case R.id.b_apti_factorial:
                Intent factorial = new Intent(this, AptiFactorial.class);
                startActivity(factorial);
                break;

        }

    }
}
