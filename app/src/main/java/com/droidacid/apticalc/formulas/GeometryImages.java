package com.droidacid.apticalc.formulas;

import android.os.Bundle;
import android.widget.ImageView;

import com.droidacid.apticalc.common.BaseActivity;
import com.droidacid.apticalc.R;

public class GeometryImages extends BaseActivity {
	private ImageView ivFor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ivFor = (ImageView) findViewById(R.id.iv_fImage);
		Bundle getPos = getIntent().getExtras();
		int pos = getPos.getInt("position");

		setImage(pos);

	}

	@Override
	public int getLayout() {
		return R.layout.f_images;
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
