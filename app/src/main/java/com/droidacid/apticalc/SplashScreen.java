package com.droidacid.apticalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Splash", "Splash Screen Started");
        setContentView(R.layout.splash_screen);


        Thread t1 = new Thread() {

            public void run() {
                try {
                    Thread.sleep(2000);
                    Intent main = new Intent(getBaseContext(), MainMenu.class);
                    startActivity(main);
                    finish();
                } catch (InterruptedException e) {

                }
            }
        };
        t1.start();

    }
}
