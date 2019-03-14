package com.example.medikan.ptsd_treatment;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AppDatabaseRepository {

    private TreatmentDao mTreatmentDao;
    private TreatmentStepDao mTreatmentStepDao;
    private LiveData<List<Treatment>> mAllTreatments;
    private LiveData<List<TreatmentStep>> mAllTreatmentSteps;
    private LiveData<List<TreatmentStep>> mSpecificTreatmentSteps;

    private AppRoomDatabase db;

    AppDatabaseRepository(Application application) {

        db = AppRoomDatabase.getDatabase(application);
        mTreatmentDao = db.treatmentDao();
        mTreatmentStepDao = db.treatmentStepsDao();
        mAllTreatments = mTreatmentDao.getAllTreatments();
        mAllTreatmentSteps = mTreatmentStepDao.getAllTreatmentSteps();
    }

    LiveData<List<Treatment>> getAllTreatments() {

        return mAllTreatments;
    }

    LiveData<List<TreatmentStep>> getAllTreatmentSteps() {
        return mAllTreatmentSteps;
    }

    LiveData<List<TreatmentStep>> getSpecificTreatmentSteps(int treatmentID) {

        mSpecificTreatmentSteps = db.treatmentStepsDao().getSpecificTreatmentSteps(treatmentID);

        return mSpecificTreatmentSteps;
    }

    public void insert (Treatment treatment) {

        new insertAsyncTask(mTreatmentDao).execute(treatment);
    }

    public void insert (TreatmentStep treatmentStep) {

        new insertAsyncTaskTreatmentStep(mTreatmentStepDao).execute(treatmentStep);
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
}
