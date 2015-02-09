package com.droidacid.apticalc.tipsandtricks;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TipsAndTricksShowTextView extends MyActionBar {
	
	TextView TvTips;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	actionBar();
	setContentView(R.layout.tat_text_detail);

	TvTips = (TextView) findViewById(R.id.tv_tat_detailed);
	
	Bundle getBasket = getIntent().getExtras();
	String mFile = getBasket.getString("tat_show_file");
	
	Spanned inHtmlCC = Html.fromHtml(getTipsText(mFile));
    TvTips.setText(inHtmlCC);
	
	}
	
	
	public String getTipsText(String filename){
		InputStream is= null;

        String about="";
		try {
			is = getResources().getAssets().open(filename);
			InputStreamReader ir = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(ir);
            String line;
            while ((line = br.readLine())!= null ) {
                about = about + line;
            }
			is.close();
		} catch (IOException e) {}

		return about;
	}

}
