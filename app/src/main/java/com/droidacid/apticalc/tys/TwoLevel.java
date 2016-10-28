package com.droidacid.apticalc.tys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.droidacid.apticalc.R;
import com.droidacid.apticalc.common.BaseActivity;

public class TwoLevel extends BaseActivity implements OnClickListener {

    final static String tag = "TYSMain1 Activity";
    private Button bAdd;
    private Button bSubtract;
    private Button bMultiply;
    private Button bDivide;
    private Button bAll;

    private static final int ADDITION = 0;
    private static final int SUBTRACT = 1;
    private static final int MULTIPLY = 2;
    private static final int DIVIDE = 3;
    private static final int ALL = 4;

    private int mQuestions;
    private int mDifficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    @Override
    public int getLayout() {
        return R.layout.tys_two_level;
    }

    private void initialize() {

        bAdd = (Button) findViewById(R.id.b_tys_Addition);
        bSubtract = (Button) findViewById(R.id.b_tys_Subtraction);
        bMultiply = (Button) findViewById(R.id.b_tys_Multiplication);
        bDivide = (Button) findViewById(R.id.b_tys_Division);
        bAll = (Button) findViewById(R.id.b_tys_All);

        bAdd.setOnClickListener(this);
        bSubtract.setOnClickListener(this);
        bMultiply.setOnClickListener(this);
        bDivide.setOnClickListener(this);
        bAll.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Bundle gotDifficulty = getIntent().getExtras();
        mDifficulty = gotDifficulty.getInt("difficulty", 0);
        Bundle QuestionType = new Bundle();
        QuestionType.putInt("difficulty", mDifficulty);

        Intent Counter = new Intent(this, ThreeCounter.class);

        switch (v.getId()) {

            case R.id.b_tys_Addition:
                mQuestions = ADDITION;
                Counter.putExtras(QuestionType);
                break;
            case R.id.b_tys_Subtraction:
                mQuestions = SUBTRACT;
                Counter.putExtras(QuestionType);
                break;
            case R.id.b_tys_Multiplication:
                mQuestions = MULTIPLY;
                Counter.putExtras(QuestionType);
                break;
            case R.id.b_tys_Division:
                mQuestions = DIVIDE;
                Counter.putExtras(QuestionType);
                break;
            case R.id.b_tys_All:
                mQuestions = ALL;
                Counter.putExtras(QuestionType);
                break;
        }
        QuestionType.putInt("questionType", mQuestions);
        Counter.putExtras(QuestionType);
        startActivity(Counter);
        finish();
    }
}
