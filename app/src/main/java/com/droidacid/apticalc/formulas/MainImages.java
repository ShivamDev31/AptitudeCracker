package com.droidacid.apticalc.formulas;

import android.os.Bundle;
import android.widget.ImageView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class MainImages extends MyActionBar {
	ImageView ivFor;

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
		case 2:
			ivFor.setImageResource(R.drawable.exponents);
			break;
		case 3:
			ivFor.setImageResource(R.drawable.logarithms);
			break;
		case 4:
			ivFor.setImageResource(R.drawable.progressions);
			break;
		case 5:
			ivFor.setImageResource(R.drawable.quadratic);
			break;
		}
	}
}
