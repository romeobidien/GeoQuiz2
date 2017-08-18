package com.canation.android.geoquiz2;

/**
 * Created by CANG on 08/18/2017.
 */

public class Question {


    private String mText;
    private boolean mAnswer;

    public Question(String text, boolean isTrue) {
        this.mText = text;
        this.mAnswer = isTrue;
    }

    public String getText() {
        return mText;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setText(String text) {
        mText = text;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
