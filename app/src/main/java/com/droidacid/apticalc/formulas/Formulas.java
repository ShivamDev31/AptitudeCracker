package com.droidacid.apticalc.formulas;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.droidacid.apticalc.R;

public class Formulas extends ListActivity {
	private ListView forList;
	private String[] f_main;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulas);

		Resources res = getResources();
		f_main = res.getStringArray(R.array.f_main);
		forList = getListView();
		adapter();
	}

	private void adapter() {
		ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, f_main);
		forList.setAdapter(mAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);

		switch (position) {
		case 0: // list
			Intent fSquares = new Intent(this, SquaresCubesFractionsList.class);
			startActivity(fSquares);
			break;
		case 1: // layout
			
			Intent divLayout = new Intent(this, DivLayout.class);
			startActivity(divLayout);
			break;
		case 2: // image
			setPosition(position);
			break;
		case 3: // image
			setPosition(position);
			break;
		case 4: // image
			setPosition(position);
			break;
		case 5: // image
			setPosition(position);
			break;
		case 6: // list
			Intent fProbability = new Intent(this, ProbalityPandCList.class);
			startActivity(fProbability);
			break;
		case 7: // list
			Intent fGeometry = new Intent(this, GeometryList.class);
			startActivity(fGeometry);
			break;
		case 8: // list
			Intent fCoGeometry = new Intent(this, CoOrdinateGeoList.class);
			startActivity(fCoGeometry);
			break;
		case 9: // list
			Intent fTrigono = new Intent(this, TrigonometryList.class);
			startActivity(fTrigono);
			break;
		}
	}

	private void setPosition(int position) {
		Intent showIt = new Intent(this, MainImages.class);
		Bundle toShow = new Bundle();
		toShow.putInt("position", position);
		showIt.putExtras(toShow);
		startActivity(showIt);
	}
}
