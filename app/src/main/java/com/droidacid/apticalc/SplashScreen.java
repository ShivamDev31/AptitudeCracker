package com.droidacid.apticalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static final String TAG = SplashScreen.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread t1 = new Thread() {

            public void run() {
                try {
                    Thread.sleep(2000);
                    Intent main = new Intent(SplashScreen.this, MainMenu.class);
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