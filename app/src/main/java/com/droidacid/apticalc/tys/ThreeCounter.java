package com.droidacid.apticalc.tys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.droidacid.apticalc.R;

public class ThreeCounter extends Activity {

	final static String tag = "Counter Class";
	TextView tvNumberOfQues, tvDifficultyType, tvQuestionsType, tvCounter;

	private CountDownTimer myTimer;
	final Context myContext = this;

	private final static int EASY = 0;
	private final static int MEDIUM = 1;
	private final static int HARD = 2;
	private static final int ADDITION = 0;
	private static final int SUBTRACT = 1;
	private static final int MULTIPLY = 2;
	private static final int DIVIDE = 3;
	private static final int ALL = 4;

	private int mDifficulty, mQuestions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//actionBar();
		setContentView(R.layout.tys_three_counter);
		initialize();
		counterTimer();
		difficulty();
		questionType();

	}

	private void initialize() {

		Bundle DifficultyType = getIntent().getExtras();
		Bundle QuestionType = getIntent().getExtras();
		mDifficulty = DifficultyType.getInt("difficulty", 0);
		mQuestions = QuestionType.getInt("questionType", 0);

		tvNumberOfQues = (TextView) findViewById(R.id.tv_tys_NumberOfQues);
		tvDifficultyType = (TextView) findViewById(R.id.tv_tys_DifficultyType);
		tvQuestionsType = (TextView) findViewById(R.id.tv_tys_QuestionsType);
		tvCounter = (TextView) findViewById(R.id.tv_tys_Counter);

	}

	private void difficulty() {
		switch (mDifficulty) {
		case EASY:
			tvDifficultyType.setText("Easy");
			tvNumberOfQues.setText("Questions :10");
			break;
		case MEDIUM:
			tvDifficultyType.setText("Medium");
			tvNumberOfQues.setText("Questions :15");
			break;
		case HARD:
			tvDifficultyType.setText("Hard");
			tvNumberOfQues.setText("Questions :20");
			break;
		}
	}

	private void questionType() {
		switch (mQuestions) {
		case ADDITION:
			tvQuestionsType.setText("Addition");
			break;
		case SUBTRACT:
			tvQuestionsType.setText("Subtraction");
			break;
		case MULTIPLY:
			tvQuestionsType.setText("Multiplication");
			break;
		case DIVIDE:
			tvQuestionsType.setText("Division");
			break;
		case ALL:
			tvQuestionsType.setText("All");
			break;
		}
	}

	private void counterTimer() {
		Log.d(tag, "Starting of counter class");
		myTimer = new CountDownTimer(3000, 1000) {

			public void onTick(long millisUntilFinished) {
				tvCounter.setText(Long.toString(millisUntilFinished / 1000));
			}

			public void onFinish() {
				tvCounter.setVisibility(View.GONE);
				Log.d(tag, "Inside the onFinish Method of counter");

				Intent calculate = new Intent(myContext, FourCalculation.class);
				calculate.putExtra("difficulty", mDifficulty);
				calculate.putExtra("questionType", mQuestions);
				startActivity(calculate);
				finish();
			}

		}.start();
	}
}
