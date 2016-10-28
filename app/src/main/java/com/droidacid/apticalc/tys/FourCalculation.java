package com.droidacid.apticalc.tys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.droidacid.apticalc.R;
import com.droidacid.apticalc.common.BaseActivity;
import com.droidacid.apticalc.tys.model.Question;

import java.util.Timer;
import java.util.TimerTask;

public class FourCalculation extends BaseActivity implements OnClickListener {
    private static final String TAG = "CalculationActivity";
    private final static int EASY = 0;
    private final static int MEDIUM = 1;
    private final static int HARD = 2;
    private static final int ADDITION = 0;
    private static final int SUBTRACT = 1;
    private static final int MULTIPLY = 2;
    private static final int DIVIDE = 3;
    private static final int ALL = 4;
    Button bOne, bTwo, bThree, bFour, bFive, bSix, bSeven, bEight, bNine,
            bZero, bClear;
    TextView tvQuestions, tvAnswers, tvTimer, tvNumberOfQuestions;
    int randomValue = (int) Math.random();
    int availableTime = 30;
    int num1, num2, result, rightAnswers, wrongAnswers, timeTaken;
    long starttime = 0;
    boolean timerGoingUp = true;
    boolean timerRunning;
    Timer upTimer = new Timer();
    private CountDownTimer timer;
    private int mDifficulty, mQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        questions();
        startTimer();
    }

    @Override
    public int getLayout() {
        return R.layout.tys_four_calculate;
    }

    private void initialize() {
        Bundle getBasket = getIntent().getExtras();
        Bundle basket = getIntent().getExtras();
        mDifficulty = getBasket.getInt("difficulty", 0);
        mQuestions = basket.getInt("questionType", 0);

        String howDifficult;
        String questionType;

        if (mDifficulty == EASY)
            howDifficult = "Easy";
        if (mDifficulty == MEDIUM)
            howDifficult = "Medium";
        if (mDifficulty == HARD)
            howDifficult = "Hard";

        if (mQuestions == ADDITION)
            questionType = "Addition";
        if (mQuestions == SUBTRACT)
            questionType = "Subtraction";
        if (mQuestions == MULTIPLY)
            questionType = "Multiplication";
        if (mQuestions == DIVIDE)
            questionType = "Division";
        if (mQuestions == ALL)
            questionType = "All";

        tvQuestions = (TextView) findViewById(R.id.tv_tys_Questions);
        tvTimer = (TextView) findViewById(R.id.tv_tys_Timer);
        tvAnswers = (TextView) findViewById(R.id.tv_tys_Answers);
        tvNumberOfQuestions = (TextView) findViewById(R.id.tv_tys_NumberOfQuestions);

        bOne = (Button) findViewById(R.id.bOne);
        bTwo = (Button) findViewById(R.id.bTwo);
        bThree = (Button) findViewById(R.id.bThree);
        bFour = (Button) findViewById(R.id.bFour);
        bFive = (Button) findViewById(R.id.bFive);
        bSix = (Button) findViewById(R.id.bSix);
        bSeven = (Button) findViewById(R.id.bSeven);
        bEight = (Button) findViewById(R.id.bEight);
        bNine = (Button) findViewById(R.id.bNine);
        bZero = (Button) findViewById(R.id.bZero);
        bClear = (Button) findViewById(R.id.bClear);

        bOne.setOnClickListener(this);
        bTwo.setOnClickListener(this);
        bThree.setOnClickListener(this);
        bFour.setOnClickListener(this);
        bFive.setOnClickListener(this);
        bSix.setOnClickListener(this);
        bSeven.setOnClickListener(this);
        bEight.setOnClickListener(this);
        bNine.setOnClickListener(this);
        bZero.setOnClickListener(this);
        bClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!timerRunning)
            return;

        switch (v.getId()) {
            case R.id.bOne:
                tvAnswers.setText(tvAnswers.getText().toString() + "1");
                break;
            case R.id.bTwo:
                tvAnswers.setText(tvAnswers.getText().toString() + "2");
                break;
            case R.id.bThree:
                tvAnswers.setText(tvAnswers.getText().toString() + "3");
                break;
            case R.id.bFour:
                tvAnswers.setText(tvAnswers.getText().toString() + "4");
                break;
            case R.id.bFive:
                tvAnswers.setText(tvAnswers.getText().toString() + "5");
                break;
            case R.id.bSix:
                tvAnswers.setText(tvAnswers.getText().toString() + "6");
                break;
            case R.id.bSeven:
                tvAnswers.setText(tvAnswers.getText().toString() + "7");
                break;
            case R.id.bEight:
                tvAnswers.setText(tvAnswers.getText().toString() + "8");
                break;
            case R.id.bNine:
                tvAnswers.setText(tvAnswers.getText().toString() + "9");
                break;
            case R.id.bZero:
                tvAnswers.setText(tvAnswers.getText().toString() + "0");
                break;
            case R.id.bClear:
                if (tvAnswers.getText().length() > 0) {
                    String txt = tvAnswers.getText().toString();
                    tvAnswers.setText(txt.substring(0, txt.length() - 1));
                }
                break;
        }

        if (tvAnswers.getText().length() == String.valueOf(result).length()) {
            verifyAnswer();
        }
    }

    private void questions() {
        int numberOfQuestions = 0;
        switch (mDifficulty) {
            case EASY:
                numberOfQuestions = 10;
                break;
            case MEDIUM:
                numberOfQuestions = 15;
                break;
            case HARD:
                numberOfQuestions = 20;
                break;
        }
        Log.w(TAG, "new set questions");
        if ((rightAnswers + wrongAnswers) >= numberOfQuestions) {
            calculateScore();

            return;
        }

        Question mQuestion = new Question(mQuestions, mDifficulty);
        tvQuestions.setText(mQuestion.getCalculation());
        result = mQuestion.getResult();
    }

    @SuppressWarnings("deprecation")
    public void verifyAnswer() {

        if (result == Integer.valueOf((String) tvAnswers.getText())) {
            rightAnswers++;
            tvNumberOfQuestions.setText(Integer.toString(rightAnswers) + "/"
                    + Integer.toString(rightAnswers + wrongAnswers));
            tvNumberOfQuestions.setTextColor(Color.GREEN);
        } else {
            wrongAnswers++;
            tvNumberOfQuestions.setText(Integer.toString(rightAnswers) + "/"
                    + Integer.toString(rightAnswers + wrongAnswers));
            tvNumberOfQuestions.setTextColor(Color.RED);

            AlertDialog wrongDialog = new AlertDialog.Builder(this).create();
            wrongDialog.setCancelable(false);
            wrongDialog.setTitle("Wrong Answer");
            wrongDialog.setMessage("Right answer is : " + result);
            wrongDialog.setButton("Ok", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });
            wrongDialog.show();
        }

        tvAnswers.setText("");
        questions();
    }

    private void calculateScore() {
        int score = 0;
        if (timerGoingUp) {
            score = (10 * (rightAnswers) - 5 * (wrongAnswers)) - timeTaken;
        } else {
            score = (10 * (rightAnswers) - 5 * (wrongAnswers))
                    + Integer.valueOf(tvTimer.getText().toString());
        }

        stopTimer();
        scoreActivity(score);
        rightAnswers = 0;
        wrongAnswers = 0;
    }

    private void scoreActivity(int score) {
        Intent scoresCalc = new Intent(this, TYSScores.class);
        Bundle scored = new Bundle();
        scored.putInt("rightanswers", rightAnswers);
        scored.putInt("wronganswers", wrongAnswers);
        scored.putInt("score", score);

        scoresCalc.putExtras(scored);
        startActivity(scoresCalc);
        finish();

    }

    private void stopTimer() {
        upTimer.cancel();
        upTimer.purge();
        if (timer != null)
            timer.cancel();
        timer = null;
        timerRunning = false;
    }

    private void startTimer() {
        if (timerGoingUp) {
            starttime = System.currentTimeMillis();
            upTimer = new Timer();
            upTimer.schedule(new MyUpTimer(), 0, 500);
        } else {
            showDownTimer();
        }
        timerRunning = true;
    }

    private void showDownTimer() {
        if (timer != null)
            timer.cancel();
        timer = new CountDownTimer(availableTime * 1000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(Long.toString(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                calculateScore();
            }
        }.start();

    }

    class MyUpTimer extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    long millis = System.currentTimeMillis() - starttime;
                    int seconds = (int) (millis / 1000);
                    timeTaken = seconds;
                    int minutes = seconds / 60;
                    seconds = seconds % 60;
                    tvTimer.setText(String.format("%d:%02d", minutes, seconds));
                }
            });
        }
    }
}
