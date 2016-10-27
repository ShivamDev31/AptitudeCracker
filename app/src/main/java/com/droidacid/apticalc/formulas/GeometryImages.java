package com.droidacid.apticalc.formulas;

import android.os.Bundle;
import android.widget.ImageView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class GeometryImages extends MyActionBar {
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
		case 5:
			ivFor.setImageResource(R.drawable.polygons);
			break;
		case 6:
			ivFor.setImageResource(R.drawable.pentagon);
			break;
		}
	}
}
