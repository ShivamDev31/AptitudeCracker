package com.droidacid.apticalc.tipsandtricks;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class TipsAndTricksDetailedView extends MyActionBar {

    private TextView tvTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar();
        setContentView(R.layout.tat_text_detail);

        tvTips = (TextView) findViewById(R.id.tv_tat_detailed);

        Bundle getBasket = getIntent().getExtras();
        String mFile = getBasket.getString("tat_show_file");

        String parsedHtml = HtmlAssetParser.parseHtml(this, mFile);
        Spanned inHtmlCC = Html.fromHtml(parsedHtml);
        tvTips.setText(inHtmlCC);
    }
}