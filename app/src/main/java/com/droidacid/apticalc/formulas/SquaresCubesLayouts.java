package com.droidacid.apticalc.formulas;

import android.os.Bundle;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;

public class SquaresCubesLayouts extends MyActionBar {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar();
		Bundle getPos = getIntent().getExtras();
		int pos = getPos.getInt("position");
		setLayout(pos);
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
