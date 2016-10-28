package com.droidacid.apticalc.formulas;

import android.os.Bundle;

import com.droidacid.apticalc.common.BaseActivity;
import com.droidacid.apticalc.R;

public class SquaresCubesLayouts extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle getPos = getIntent().getExtras();
		int pos = getPos.getInt("position");
		setLayout(pos);
	}

	@Override
	public int getLayout() {
		return 0;
	}

	private void setLayout(int pos) {
		switch (pos) {

		case 0:
			setContentView(R.layout.fsquares);
			break;
		case 1:
			setContentView(R.layout.fcubes);
			break;
		case 2:
			setContentView(R.layout.fdecimals);
			break;
		}
	}
}
