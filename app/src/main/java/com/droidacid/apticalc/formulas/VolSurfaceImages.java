package com.droidacid.apticalc.formulas;

import android.os.Bundle;
import android.widget.ImageView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class VolSurfaceImages extends MyActionBar {
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
			ivFor.setImageResource(R.drawable.volume_cone);
			break;
		case 1:
			ivFor.setImageResource(R.drawable.volume_cube);
			break;
		case 2:
			ivFor.setImageResource(R.drawable.volume_cylinder);
			break;
		case 3:
			ivFor.setImageResource(R.drawable.volume_frustrum);
			break;
		case 4:
			ivFor.setImageResource(R.drawable.volume_pyramid);
			break;
		case 5:
			ivFor.setImageResource(R.drawable.volume_sphere);
			break;
		}
	}
}
