package com.droidacid.apticalc.formulas;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.droidacid.apticalc.R;

public class GeometryList extends ListActivity {
	private ListView probList;
	private String[] f_geo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulas);
		Resources res = getResources();
		f_geo = res.getStringArray(R.array.f_geometry);
		probList = getListView();
		adapter();
	}

	private void adapter() {
		ArrayAdapter<String> mAdpater = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, f_geo);
		probList.setAdapter(mAdpater);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);
		switch (position) {

		case 0: // list
			Intent geoFund = new Intent(this, GeoFundList.class);
			startActivity(geoFund);
			break;
		case 1: // list
			Intent areaPeri = new Intent(this, AreasPeriList.class);
			startActivity(areaPeri);
			break;
		case 2: // list
			Intent volSurface = new Intent(this, VolSurfaceList.class);
			startActivity(volSurface);
			break;
		case 3: // list
			Intent circleProp = new Intent(this, CirclePropList.class);
			startActivity(circleProp);
			break;
		case 4: // list
			Intent triProp = new Intent(this, TrianglePropList.class);
			startActivity(triProp);
			break;
		case 5: // image
			setPosition(position);
			break;
		case 6: // image
			setPosition(position);
			break;
		}
	}

	private void setPosition(int position) {
		Intent showIt = new Intent(this, GeometryImages.class);
		Bundle toShow = new Bundle();
		toShow.putInt("position", position);
		showIt.putExtras(toShow);
		startActivity(showIt);
	}
}
