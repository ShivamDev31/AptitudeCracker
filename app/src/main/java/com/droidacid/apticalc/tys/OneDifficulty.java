package com.droidacid.apticalc.tys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.droidacid.apticalc.common.BaseActivity;
import com.droidacid.apticalc.R;

public class OneDifficulty extends BaseActivity implements OnClickListener,
        OnCheckedChangeListener {

    private final static int EASY = 0;
    private final static int MEDIUM = 1;
    private final static int HARD = 2;

    int mDifficultyType = EASY;

    final static String tag = "Test Your Skills";

    private RadioGroup rgDiffLevel;
    private Button bContinue;
    private Button bHighScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    @Override
    public int getLayout() {
        return R.layout.tys_one_dificulty;
    }

    private void initialize() {

        rgDiffLevel = (RadioGroup) findViewById(R.id.rg_tys_DiffLevel);
        bContinue = (Button) findViewById(R.id.b_tys_Continue);
        bHighScores = (Button) findViewById(R.id.b_tys_HighScores);

        rgDiffLevel.setOnCheckedChangeListener(this);
        bContinue.setOnClickListener(this);
        bHighScores.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.b_tys_Continue:

                //displayInterstitialAd();
                // Log.d(tag, "Inside On Click Continue button");
                Bundle basket = new Bundle();
                basket.putInt("difficulty", mDifficultyType);
                Intent Continue = new Intent(this, TwoLevel.class);
                Continue.putExtras(basket);
                startActivity(Continue);
                break;

            case R.id.b_tys_HighScores:
                Intent highScore = new Intent(this, HighScores.class);
                startActivity(highScore);
                break;
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.rb_tys_Easy:
                mDifficultyType = EASY;
                break;
            case R.id.rb_tys_Medium:
                mDifficultyType = MEDIUM;
                break;
            case R.id.rb_tys_Hard:
                mDifficultyType = HARD;
                break;
        }

    }
}
