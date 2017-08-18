package com.canation.android.geoquiz2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private TextView mQuestionTextView;
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mPrevButton;
    private Button mNextButton;

    private Question[] mQuestionBank;
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        initQuestions();

        mQuestionTextView = (TextView) findViewById(R.id.question_textView);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mPrevButton = (Button) findViewById(R.id.previous_button);
        mNextButton = (Button) findViewById(R.id.next_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeIndex(-1);
                showQuestion();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeIndex(1);
                showQuestion();
            }
        });

        showQuestion();
    }

    private void initQuestions() {
        String[] questionTexts = getResources().getStringArray(R.array.questions_text);
        int[] answers = getResources().getIntArray(R.array.answers_array);
        int length = answers.length;

        mQuestionBank = new Question[length];
        for (int i = 0; i < length; i++) {
            mQuestionBank[i] = new Question(questionTexts[i], answers[i] == 1 ? true : false);
        }
    }

    private void showQuestion() {
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getText());
    }

    private void checkAnswer(boolean answer) {
        if (answer == mQuestionBank[mCurrentIndex].getAnswer()) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    private void changeIndex(int n) {
        mCurrentIndex = (mCurrentIndex + mQuestionBank.length + n)% mQuestionBank.length;
    }
}
