package com.droidacid.apticalc.formulas;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.droidacid.apticalc.R;

public class CoOrdinateGeoList extends ListActivity {
	private ListView probList;
	private String[] f_co_ord_geo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulas);
		Resources res = getResources();
		f_co_ord_geo = res.getStringArray(R.array.f_co_geo);
		probList = getListView();
		adapter();
	}

	private void adapter() {
		ArrayAdapter<String> mAdpater = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, f_co_ord_geo);
		probList.setAdapter(mAdpater);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);
		Intent showIt = new Intent(this, CoOrdinateGeoImages.class);
		Bundle toShow = new Bundle();
		toShow.putInt("position", position);
		showIt.putExtras(toShow);
		startActivity(showIt);
	}
}
