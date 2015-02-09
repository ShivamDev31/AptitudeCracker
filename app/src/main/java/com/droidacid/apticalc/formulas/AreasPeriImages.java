package com.droidacid.apticalc.formulas;

import android.os.Bundle;
import android.widget.ImageView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class AreasPeriImages extends MyActionBar {
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
			ivFor.setImageResource(R.drawable.area_circle);
			break;
		case 1:
			ivFor.setImageResource(R.drawable.area_triangle);
			break;
		case 2:
			ivFor.setImageResource(R.drawable.area_equitriangle);
			break;
		case 3:
			ivFor.setImageResource(R.drawable.area_square);
			break;
		case 4:
			ivFor.setImageResource(R.drawable.area_rectangle);
			break;
		case 5:
			ivFor.setImageResource(R.drawable.area_parellogram);
			break;
		case 6:
			ivFor.setImageResource(R.drawable.area_ring);
			break;
		case 7:
			ivFor.setImageResource(R.drawable.area_sector);
			break;
		case 8:
			ivFor.setImageResource(R.drawable.area_trapezoid);
			break;
		}
	}
}
