package com.droidacid.apticalc.formulas;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.droidacid.apticalc.R;

public class VolSurfaceList extends ListActivity {
	private ListView probList;
	private String[] f_vol_sur;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulas);
		Resources res = getResources();
		f_vol_sur = res.getStringArray(R.array.f_vol_surface);
		probList = getListView();
		adapter();
	}

	private void adapter() {
		ArrayAdapter<String> mAdpater = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, f_vol_sur);
		probList.setAdapter(mAdpater);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);
		Intent showIt = new Intent(this, VolSurfaceImages.class);
		Bundle toShow = new Bundle();
		toShow.putInt("position", position);
		showIt.putExtras(toShow);
		startActivity(showIt);
	}
}
