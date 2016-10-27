package com.droidacid.apticalc.formulas;

import android.os.Bundle;
import android.widget.ImageView;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class TrianglePropImages extends MyActionBar {
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
			ivFor.setImageResource(R.drawable.triangle1);
			break;
		case 1:
			ivFor.setImageResource(R.drawable.triangle2);
			break;
		case 2:
			ivFor.setImageResource(R.drawable.triangle3);
			break;
		case 3:
			ivFor.setImageResource(R.drawable.triangle4);
			break;
		case 4:
			ivFor.setImageResource(R.drawable.triangle5);
			break;
		case 5:
			ivFor.setImageResource(R.drawable.triangle6);
			break;
		case 6:
			ivFor.setImageResource(R.drawable.triangle7);
			break;
		case 7:
			ivFor.setImageResource(R.drawable.triangle8);
			break;
		case 8:
			ivFor.setImageResource(R.drawable.triangle9);
			break;
		}
	}
}
