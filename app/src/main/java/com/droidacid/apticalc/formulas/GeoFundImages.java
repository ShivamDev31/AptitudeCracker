package com.droidacid.apticalc.formulas;

import android.os.Bundle;
import android.widget.ImageView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class GeoFundImages extends MyActionBar {
	private ImageView ivFor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar();
		setContentView(R.layout.f_images);

		ivFor = (ImageView) findViewById(R.id.iv_fImage);
		Bundle getPos = getIntent().getExtras();
		int pos = getPos.getInt("position");

		setImage(pos);

	}

	private void setImage(int pos) {
		switch (pos) {
		case 0:
			ivFor.setImageResource(R.drawable.geometry1);
			break;
		case 1:
			ivFor.setImageResource(R.drawable.geometry2);
			break;
		case 2:
			ivFor.setImageResource(R.drawable.geometry3);
			break;
		case 3:
			ivFor.setImageResource(R.drawable.geometry4);
			break;
		case 4:
			ivFor.setImageResource(R.drawable.geometry5);
			break;
		}
	}
}
