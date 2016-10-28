package com.droidacid.apticalc.common;

import android.content.Intent;
import android.os.Bundle;

import com.droidacid.apticalc.R;

public class SplashScreen extends BaseActivity {

    private static final String TAG = SplashScreen.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stopForTwoSeconds();
    }

    @Override
    public int getLayout() {
        return R.layout.splash_screen;
    }

    private void stopForTwoSeconds() {
        Thread t1 = new Thread() {

            public void run() {
                try {
                    Thread.sleep(2000);
                    Intent main = new Intent(SplashScreen.this, MainScreenActivity.class);
                    startActivity(main);
                    finish();
                } catch (InterruptedException e) {
                    L.l(TAG, "Exception : " + e);
                }
            }
        };
        t1.start();
    }
}