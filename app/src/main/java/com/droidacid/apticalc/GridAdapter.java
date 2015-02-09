package com.droidacid.apticalc;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class SingleItem {
	int image;
	String text;

	SingleItem(int image, String text) {
		this.image = image;
		this.text = text;
	}
}

public class GridAdapter extends BaseAdapter {

	ArrayList<SingleItem> list;
	Context context;

	GridAdapter(Context c) {
		context = c;
		list = new ArrayList<SingleItem>();
		Resources res = c.getResources();
		String[] texts = res.getStringArray(R.array.grid_texts);
		int[] images = { R.drawable.calc, R.drawable.test, R.drawable.temptip,
				R.drawable.formulas };
		for (int i = 0; i < 4; i++) {
			list.add(new SingleItem(images[i], texts[i]));
		}
	}

	@Override
	public int getCount() {

		return list.size();
	}

	@Override
	public Object getItem(int i) {

		return list.get(i);
	}

	@Override
	public long getItemId(int i) {

		return i;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		LayoutInflater inflator = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View grid = inflator.inflate(R.layout.grid_item, viewGroup, false);
		ImageView image = (ImageView) grid.findViewById(R.id.gridImage);
		TextView button = (TextView) grid.findViewById(R.id.gridButton);
		SingleItem myGrid = list.get(i);
		image.setImageResource(myGrid.image);
		button.setText(myGrid.text);
		
		return grid;
	}

}
