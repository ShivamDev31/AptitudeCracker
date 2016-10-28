package com.droidacid.apticalc.common;

import android.app.Application;

/**
 * Created by shivam on 28/10/16.
 */

public class AptitudeApplication extends Application {

    private static AptitudeApplication instance;

    public static AptitudeApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}