package com.droidacid.apticalc.more;

import android.os.Bundle;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class AboutUs extends MyActionBar {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		showActionBar();
		setContentView(R.layout.more_about_us);
	}
}