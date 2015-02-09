package com.droidacid.apticalc.tys.model;

import java.util.List;

import com.droidacid.apticalc.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class HighScoreListAdapter extends ArrayAdapter<ScoreEntry> {
    private final LayoutInflater mInflater;

    public HighScoreListAdapter(Context context) {
    	
        super(context, android.R.layout.simple_list_item_2);
    	
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<ScoreEntry> entries) {
        clear();
        if (entries != null) {
        	for (ScoreEntry entry: entries)
            add(entry);
        }
    }

    /**
     * Populate new items in the list.
     */
    @Override public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.tys_highscore_item, parent, false);
        } else {
            view = convertView;
        }
        
        ScoreEntry entry = this.getItem(position);
        
        ((TextView)view.findViewById(R.id.tv_tys_high_name)).setText(entry.getName());
        ((TextView)view.findViewById(R.id.tv_tys_high_score)).setText(Integer.toString(entry.getScore()));
		
        return view;
    }
    
}