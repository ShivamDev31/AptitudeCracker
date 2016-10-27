package com.droidacid.apticalc.formulas;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.droidacid.apticalc.R;

public class SquaresCubesFractionsList extends ListActivity {
	private ListView forList;
	private String[] f_squares;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulas);
		Resources res = getResources();
		f_squares = res.getStringArray(R.array.f_squares);
		forList = getListView();
		adapter();
	}

	private void adapter() {
		ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, f_squares);
		forList.setAdapter(mAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		switch (position) {
		case 0:
			setPosition(position);
			break;
		case 1:
			setPosition(position);
			break;
		case 2:
			setPosition(position);
			break;

		}
	}

	private void setPosition(int position) {
		Intent showIt = new Intent(this, SquaresCubesLayouts.class);
		Bundle toShow = new Bundle();
		toShow.putInt("position", position);
		showIt.putExtras(toShow);
		startActivity(showIt);
	}

}
