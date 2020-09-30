package com.example.medikan.ptsd_treatment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class TestPage extends AppCompatActivity {

    public TextView testQuestionHeaderText, testQuestionText;
    public RadioGroup testQuestionAnswers;

    private TestQuestionViewModel mTestQuestionViewModel;
    private List<TestQuestion> mTestQuestions;
    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_page);

        testQuestionHeaderText = (TextView) findViewById(R.id.testQuestionHeading);
        testQuestionText = (TextView) findViewById((R.id.testQuestion));
        testQuestionAnswers = (RadioGroup) findViewById(R.id.radioGroupTestAnswers);

        mTestQuestionViewModel = ViewModelProviders.of(this).get(TestQuestionViewModel.class);
        mTestQuestionViewModel.getAllTestQuestions().observe(this, new Observer<List<TestQuestion>>() {
            @Override
            public void onChanged(@Nullable List<TestQuestion> testQuestions) {
                mTestQuestions = testQuestions;
                setupText(questionIndex);
            }
        });
    }

    public void setupText(final int index) {
        testQuestionHeaderText.setText((CharSequence) mTestQuestions.get(index).getQuestion());
    }

    public void handleClick(View view) {
        int testAnswerId = testQuestionAnswers.getCheckedRadioButtonId();
        View checkedAnswer = testQuestionAnswers.findViewById(testAnswerId);
        int index = testQuestionAnswers.indexOfChild(checkedAnswer);

        mTestQuestions.get(questionIndex).setRating(index);
        testQuestionAnswers.clearCheck();
        if (questionIndex < mTestQuestions.size() - 1)
        {
            setupText(++questionIndex);
        }
        else
        {
            navigateToTestCompletedPage(view);
        }
    }

    public void navigateToTestCompletedPage(View view) {
        Intent intent = new Intent(this, TestCompletedPage.class);
        startActivity(intent);
    }
}
