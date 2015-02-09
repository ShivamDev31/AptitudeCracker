package com.droidacid.apticalc.tys;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.droidacid.apticalc.R;
import com.droidacid.apticalc.tys.model.HighScoreListAdapter;
import com.droidacid.apticalc.tys.model.ScoreEntry;

import java.util.ArrayList;
import java.util.List;

public class HighScores extends ListActivity {

	private static final String tag = "HighScores";
	private HighScoreListAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//actionBar();
		setContentView(R.layout.tys_high_score);

		
		if ( mAdapter == null){
			mAdapter = new HighScoreListAdapter(this);
			setListAdapter(mAdapter);		
		}
		mAdapter.setData(getScoreList());
	}
	

	

	private List<ScoreEntry> getScoreList() {
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		int numberEntries = getPrefs.getInt("entries", 0);			
		List<ScoreEntry> entries = new ArrayList<ScoreEntry>();
		
		for (int i = 0;  i < numberEntries ; i++){
			String high = getPrefs.getString("high_"+Integer.toString(i), "name,12");
			String[] highA = high.split(",");
			ScoreEntry entry = new ScoreEntry(highA[0], Integer.valueOf(highA[1]));
			entries.add(entry);
		}
		return entries;
	}




	@Override
	protected void onPause() {
		
		super.onPause();
		finish();
	}
}
