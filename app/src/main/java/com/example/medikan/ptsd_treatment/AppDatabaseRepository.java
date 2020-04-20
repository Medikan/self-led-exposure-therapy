package com.example.medikan.ptsd_treatment;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AppDatabaseRepository {

    private TreatmentDao mTreatmentDao;
    private TreatmentStepDao mTreatmentStepDao;
    private TestQuestionDao mTestQuestionDao;
    private LiveData<List<Treatment>> mAllTreatments, mAllRequiredTreatments;
    private LiveData<Treatment> mSpecificTreatment;
    private LiveData<List<TreatmentStep>> mAllTreatmentSteps;
    private LiveData<List<TreatmentStep>> mSpecificTreatmentSteps;
    private LiveData<TreatmentStep> mTreatmentStep;
    private LiveData<List<TestQuestion>> mTestQuestions;
    private LiveData<TestQuestion> mTestQuestion;

    private AppRoomDatabase db;

    AppDatabaseRepository(Application application) {

        db = AppRoomDatabase.getDatabase(application);
        mTreatmentDao = db.treatmentDao();
        mTreatmentStepDao = db.treatmentStepsDao();
        mTestQuestionDao = db.testQuestionDao();
        mAllTreatments = mTreatmentDao.getAllTreatments();
        mAllRequiredTreatments = mTreatmentDao.getAllRequiredTreatments();
        mAllTreatmentSteps = mTreatmentStepDao.getAllTreatmentSteps();
        mTestQuestions = mTestQuestionDao.getAllTestQuestions();
    }

    LiveData<List<Treatment>> getAllTreatments() {

        return mAllTreatments;
    }

    LiveData<List<Treatment>> getAllRequiredTreatments() { return mAllRequiredTreatments; }

    LiveData<Treatment> getSpecificTreatment(int treatmentID) {

        mSpecificTreatment = db.treatmentDao().getSpecificTreatment(treatmentID);

        return mSpecificTreatment;
    }

    LiveData<List<TreatmentStep>> getAllTreatmentSteps() {
        return mAllTreatmentSteps;
    }

    LiveData<List<TreatmentStep>> getSpecificTreatmentSteps(int treatmentID) {

        mSpecificTreatmentSteps = db.treatmentStepsDao().getSpecificTreatmentSteps(treatmentID);

        return mSpecificTreatmentSteps;
    }

    LiveData<List<TestQuestion>> getAllTestQuestions() { return mTestQuestions; }

    LiveData<TestQuestion> getTestQuestion(int testQuestionID) {

        mTestQuestion = db.testQuestionDao().getTestQuestion((testQuestionID));

        return mTestQuestion;
    }

    LiveData<TreatmentStep> getTreatmentStep(int treatmentStepID) {

        mTreatmentStep = db.treatmentStepsDao().getTreatmentStep(treatmentStepID);

        return mTreatmentStep;
    }

    public void insert (Treatment treatment) {

        new insertAsyncTask(mTreatmentDao).execute(treatment);
    }

    public void update (Treatment treatment) {

        new updateAsyncTaskTreatment(mTreatmentDao).execute(treatment);
    }

    public void insert (TreatmentStep treatmentStep) {

        new insertAsyncTaskTreatmentStep(mTreatmentStepDao).execute(treatmentStep);
    }

    public void update(TreatmentStep treatmentStep) {

        new updateAsyncTaskTreatmentStep(mTreatmentStepDao).execute(treatmentStep);
    }

    public void insert (TestQuestion testQuestion) {

        new insertAsyncTaskTestQuestion(mTestQuestionDao).execute(testQuestion);
    }

    public void update (TestQuestion testQuestion) {

        new updateAsyncTaskTestQuestion(mTestQuestionDao).execute(testQuestion);
    }

    private static class insertAsyncTask extends AsyncTask<Treatment, Void, Void> {

        private TreatmentDao mAsyncTaskDao;

        insertAsyncTask(TreatmentDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Treatment... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertAsyncTaskTreatmentStep extends AsyncTask<TreatmentStep, Void, Void> {

        private TreatmentStepDao mAsyncTaskDao;

        insertAsyncTaskTreatmentStep(TreatmentStepDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final TreatmentStep... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertAsyncTaskTestQuestion extends AsyncTask<TestQuestion, Void, Void> {

        private TestQuestionDao mTestQuestionDao;

        insertAsyncTaskTestQuestion(TestQuestionDao dao) {
            mTestQuestionDao = dao;
        }

        @Override
        protected Void doInBackground(final TestQuestion... params) {
            mTestQuestionDao.insert(params[0]);
            return null;
        }
    }

    private static class updateAsyncTaskTreatment extends AsyncTask<Treatment, Void, Void> {

        private TreatmentDao mAsyncTaskDao;

        updateAsyncTaskTreatment(TreatmentDao dao) { mAsyncTaskDao = dao; }

        @Override
        protected Void doInBackground(final Treatment... params) {

            mAsyncTaskDao.updateTreatments(params[0]);
            return null;
        }
    }

    private static class updateAsyncTaskTreatmentStep extends AsyncTask<TreatmentStep, Void, Void> {

        private TreatmentStepDao mAsyncTaskDao;

        updateAsyncTaskTreatmentStep(TreatmentStepDao dao) { mAsyncTaskDao = dao; };

        @Override
        protected Void doInBackground(final TreatmentStep... params) {

            mAsyncTaskDao.updateTreatmentSteps(params[0]);
            return null;
        }
    }

    private static class updateAsyncTaskTestQuestion extends AsyncTask<TestQuestion, Void, Void> {

        private TestQuestionDao mTestQuestionDao;

        updateAsyncTaskTestQuestion(TestQuestionDao dao) {
            mTestQuestionDao = dao;
        }

        @Override
        protected Void doInBackground(final TestQuestion... params) {
            mTestQuestionDao.updateTestQuestions(params[0]);
            return null;
        }
    }
}
