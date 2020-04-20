package com.example.medikan.ptsd_treatment;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class TestQuestionViewModel extends AndroidViewModel {

    private AppDatabaseRepository mRepository;
    private LiveData<List<TestQuestion>> mAllTestQuestions;
    private LiveData<TestQuestion> mTestQuestion;

    public TestQuestionViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AppDatabaseRepository(application);
        mAllTestQuestions = mRepository.getAllTestQuestions();
    }

    LiveData<List<TestQuestion>> getAllTestQuestions() {return mAllTestQuestions;}

    LiveData<TestQuestion> getTestQuestion(int testQuestionID) {

        mTestQuestion = mRepository.getTestQuestion(testQuestionID);

        return mTestQuestion;
    }

    public void insert(TestQuestion testQuestion) {mRepository.insert(testQuestion);}

    public void update(TestQuestion testQuestion) {mRepository.update(testQuestion);}
}
