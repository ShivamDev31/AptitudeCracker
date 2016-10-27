package com.droidacid.apticalc.tipsandtricks;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by shivam on 26/10/16.
 */

public class HtmlAssetParser {

    public static String parseHtml(Context context, String filename) {
        InputStream is = null;

        String about = "";
        try {
            is = context.getResources().getAssets().open(filename);
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(ir);
            String line;
            while ((line = br.readLine()) != null) {
                about = about + line;
            }
            is.close();
        } catch (IOException e) {
        }

        return about;
    }
}
