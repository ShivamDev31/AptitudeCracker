package com.droidacid.apticalc.formulas;

import android.os.Bundle;
import android.widget.ImageView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class CoOrdinateGeoImages extends MyActionBar {
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
		case 0:
			ivFor.setImageResource(R.drawable.line_equation);
			break;
		case 1:
			ivFor.setImageResource(R.drawable.line_distance);
			break;
		case 2:
			ivFor.setImageResource(R.drawable.line_midpoint);
			break;
		case 3:
			ivFor.setImageResource(R.drawable.line_slope);
			break;
		case 4:
			ivFor.setImageResource(R.drawable.line_slope_parallel);
			break;
		case 5:
			ivFor.setImageResource(R.drawable.line_slope_perpendicular);
			break;
		case 6:
			ivFor.setImageResource(R.drawable.circle_equation);
			break;
		}
	}
}
