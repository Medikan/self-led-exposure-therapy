package com.example.medikan.ptsd_treatment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class TestPage extends AppCompatActivity {

    public TextView testQuestionHeaderText, testQuestionText;
    public RatingBar testQuestionRatingBar;

    private TestQuestionViewModel mTestQuestionViewModel;
    private LiveData<List<TestQuestion>> testQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_page);

        testQuestionHeaderText = (TextView) findViewById(R.id.testQuestionHeading);
        testQuestionText = (TextView) findViewById((R.id.testQuestion));
        testQuestionRatingBar = (RatingBar) findViewById(R.id.testRatingBar);

        populateTestQuestions();
        setupText(1);
    }

    public void populateTestQuestions() {
        mTestQuestionViewModel = ViewModelProviders.of(this).get(TestQuestionViewModel.class);

        testQuestions = mTestQuestionViewModel.getAllTestQuestions();
    }

    public void setupText(final int index) {
        testQuestionHeaderText.setText((CharSequence) testQuestions.getValue());
    }

    public void navigateToTestCompletedPage(View view) {
        Intent intent = new Intent(this, TestCompletedPage.class);
        startActivity(intent);
    }
}
