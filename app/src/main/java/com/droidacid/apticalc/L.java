package com.droidacid.apticalc;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class L {

    private static final String TAG = L.class.getSimpleName();

    public static void t(Context a, String msg) {
        Toast.makeText(a, msg, Toast.LENGTH_SHORT).show();
    }

    public static void l(String msg) {
        Log.d(TAG, msg);
    }

    public static void l(String tag, String msg) {
        Log.d(tag, msg);
    }
}
