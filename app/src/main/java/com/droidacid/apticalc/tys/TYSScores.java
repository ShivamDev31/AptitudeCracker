package com.droidacid.apticalc.tys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.droidacid.apticalc.MyActionBar;
import com.droidacid.apticalc.R;
import com.droidacid.apticalc.tys.model.ScoreEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TYSScores extends MyActionBar implements OnClickListener {

    static final String tag = "Inside CalcScore";

    private TextView rightAnswers;
    private TextView wrongAnswers;
    private TextView totalScore;
    private Button bHighScores;
    private Button bPlayAgain;

    private int rightAns;
    private int wrongAns;
    private int score;
    private String rightAnswer;
    private String wrongAnswer;
    private String myScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar();
        setContentView(R.layout.tys_scores);
        initialize();
    }

    private void initialize() {

        rightAnswers = (TextView) findViewById(R.id.tv_tys_RightAnswers);
        wrongAnswers = (TextView) findViewById(R.id.tv_tys_WrongAnswers);
        totalScore = (TextView) findViewById(R.id.tv_tys_TotalScore);
        bHighScores = (Button) findViewById(R.id.b_tys_HighScores);
        bPlayAgain = (Button) findViewById(R.id.b_tys_PlayAgain);

        bHighScores.setOnClickListener(this);
        bPlayAgain.setOnClickListener(this);

        Bundle getScore = getIntent().getExtras();
        rightAns = getScore.getInt("rightanswers");
        wrongAns = getScore.getInt("wronganswers");
        score = getScore.getInt("score");

        if (isHighScore(score)) figureOutName(score);

        getValuesToString();

        setValuesToTextViews();
    }

    public void generateScore(View v) {
        // to hide this method and its button set visibility to gone in the xml
        int generatedScore = (int) (50 + (Math.random() * 30));
        Toast.makeText(this, "Generated: " + Integer.toString(generatedScore), Toast.LENGTH_SHORT).show();
        if (isHighScore(generatedScore)) figureOutName(generatedScore);

    }

    private void figureOutName(final int score) {
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        final String lastName = getPrefs.getString("lastName", "enter your name");

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater li = LayoutInflater.from(this);
        //TODO: this dialog can be much more beautiful. some textview or whatever..
        //TODO: this dialog needs to be filled with @strings instead of hard coded strings
        View baseView = li.inflate(R.layout.tys_score_newdialog, null);
        alertDialogBuilder.setView(baseView);

        final TextView tvCongrats = (TextView) baseView.findViewById(R.id.tv_tys_congrats);
        tvCongrats.setText("New highscore of " + Integer.toString(score));
        final EditText userInput = (EditText) baseView.findViewById(R.id.et_tys_nameInput);
        userInput.setHint(lastName);
        userInput.setHintTextColor(Color.DKGRAY);

        alertDialogBuilder
                .setCancelable(false)
                .setTitle("HighScore!")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (!userInput.getText().toString().equals("")) {
                                    String newName = userInput.getText().toString();
                                    saveScore(newName, score);
                                } else {
                                    saveScore(lastName, score);
                                }
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void saveScore(String name, int score) {
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        int numberEntries = getPrefs.getInt("entries", 0);

        //Log.d(tag, "numberEntries= "+ Integer.toString(numberEntries));
        ScoreEntry newEntry = new ScoreEntry(name, score);
        //Log.d(tag, "newEntry= "+ newEntry.getName()+" "+Integer.toString(newEntry.getScore()));

        List<ScoreEntry> entries = new ArrayList<ScoreEntry>();
        for (int i = 0; i < numberEntries; i++) {
            String high = getPrefs.getString("high_" + Integer.toString(i), "name,12");
            String[] highA = high.split(",");
            ScoreEntry entry = new ScoreEntry(highA[0], Integer.valueOf(highA[1]));
            entries.add(entry);
        }
        //Log.d(tag, "entries.size= " + Integer.toString(entries.size()));

        Collections.sort(entries);
        if (entries.size() < 5) {
            entries.add(newEntry);
        } else {
            entries.remove(entries.size() - 1);
            entries.add(newEntry);
        }
        Collections.sort(entries);

        //Log.d(tag, "entries.size= " + Integer.toString(entries.size()));

        String scores = "";
        Editor editor = getPrefs.edit();
        for (int i = 0; i < entries.size(); i++) {
            String aName = entries.get(i).getName();
            String aScore = Integer.toString(entries.get(i).getScore());
            scores = scores + " " + aScore;
            editor.putString("high_" + Integer.toString(i), aName + "," + aScore);
        }

        //Log.d(tag, "adding entries: " + Integer.toString(entries.size()));
        //Log.d(tag, "added scores: "+ scores);

        editor.putString("lastName", name);
        editor.putInt("entries", entries.size());
        editor.commit();
    }

    private boolean isHighScore(int score) {
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        int numberEntries = getPrefs.getInt("entries", 0);
        //Log.d(tag, "is highscore entries = " + Integer.toString(numberEntries));
        // only check if there are entries to be compared with
        if (numberEntries > 0) {
            // if we have less than 5 entries, also a new high score
            if (numberEntries < 5) return true;

            List<ScoreEntry> entries = new ArrayList<ScoreEntry>();
            for (int i = 0; i < numberEntries; i++) {
                String high = getPrefs.getString("high_" + Integer.toString(i), "name,12");
                String[] highA = high.split(",");
                ScoreEntry entry = new ScoreEntry(highA[0], Integer.valueOf(highA[1]));
                entries.add(entry);
            }

            //Log.d(tag, "is highscore entries.size= " + Integer.toString(entries.size()));
            Collections.sort(entries);
            // higher than, OR EQUAL TO (FOR SOME USER SATISAFACTION), the lowest one known
            if ((score >= entries.get(entries.size() - 1).getScore())) {
                //int oldHighest = entries.get(entries.size()-1).getScore();
                //Log.d(tag, "new HighScore: "+ Integer.toString(score)+ " ,higher than " + Integer.toString(oldHighest));
                return true;
            }
            // this score was not higher than the lowest one known
            return false;
        } else {
            // this score was the first score ever!
            return true;
        }
    }

    private void getValuesToString() {
        //Log.d(tag, "inside getValuesToString method");
        rightAnswer = Integer.toString(rightAns);
        wrongAnswer = Integer.toString(wrongAns);
        myScore = Integer.toString(score);
    }

    private void setValuesToTextViews() {
        //Log.d(tag, "inside setValuesToTextViews method");
        rightAnswers.setText("Right Answers : " + rightAnswer);
        wrongAnswers.setText("Wrong Answers : " + wrongAnswer);
        totalScore.setText("Total Score : " + myScore);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_tys_HighScores:
                Intent highScore = new Intent(this, HighScores.class);
                startActivity(highScore);
                break;
            case R.id.b_tys_PlayAgain:
                Intent playAgain = new Intent(this, OneDifficulty.class);
                startActivity(playAgain);
                break;
        }
    }

    @Override
    public void onPause() {

        super.onPause();
        finish();
    }

}