package com.droidacid.apticalc.tys.model;

public class ScoreEntry implements Comparable<ScoreEntry>{

	int mScore;
	String mName;
	
	public ScoreEntry(String name, int score){
		mName = name;
		mScore = score;
	}
	
	public int getScore(){
		return mScore;
	}
	
	public String getName(){
		return mName;
	}
	
	@Override
	public int compareTo(ScoreEntry entry) {
		int num = 0;
		if (this.mScore < entry.mScore ) num = 1; 
		if (this.mScore == entry.mScore ) num =  0;
		if (this.mScore > entry.mScore ) num =  -1;
		return num;
	}

}
