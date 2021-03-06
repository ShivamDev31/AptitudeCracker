package com.droidacid.apticalc.formulas;

import android.os.Bundle;
import android.widget.ImageView;

import com.droidacid.apticalc.common.BaseActivity;
import com.droidacid.apticalc.R;

public class TrigonometryImages extends BaseActivity {
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
		case 0:
			ivFor.setImageResource(R.drawable.trigonometry_basics);
			break;
		case 1:
			ivFor.setImageResource(R.drawable.trigonometry_common_angles);
			break;
		case 2:
			ivFor.setImageResource(R.drawable.trigonometry_periodicformulas);
			break;
		case 3:
			ivFor.setImageResource(R.drawable.trigonometry_pythagorean);
			break;
		case 4:
			ivFor.setImageResource(R.drawable.trigonometry_others);
			break;
		}
	}
}
