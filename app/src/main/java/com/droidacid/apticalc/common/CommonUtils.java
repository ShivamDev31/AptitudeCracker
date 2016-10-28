package com.droidacid.apticalc.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by shivam on 28/10/16.
 */

public class CommonUtils {

    public static void startActivity(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    public static void startActivityWithAction(Context context, String action) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        if (!TextUtils.isEmpty(action)) {
            intent.setData(Uri.parse(action));
        }
        context.startActivity(intent);
    }
}