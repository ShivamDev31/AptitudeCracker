package com.droidacid.apticalc.tipsandtricks;

import com.droidacid.apticalc.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TipsListAdapter extends ArrayAdapter<String> {
    private final LayoutInflater mInflater;

    public TipsListAdapter(Context context) {
    	
        super(context, android.R.layout.simple_list_item_2);
    	
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(String[] tips) {
        clear();
        if (tips != null) {
        	for (String tip: tips)
            add(tip);
        }
    }

    /**
     * Populate new items in the list.
     */
    @Override public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.tat_list_item, parent, false);
        } else {
            view = convertView;
        }
        
        String data = this.getItem(position);
        ((TextView)view.findViewById(R.id.tv_tat_listitem)).setText(data);
		
        return view;
    }
    
}