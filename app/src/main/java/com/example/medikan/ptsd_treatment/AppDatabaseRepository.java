package com.example.medikan.ptsd_treatment;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AppDatabaseRepository {

    private TreatmentDao mTreatmentDao;
    private TreatmentStepDao mTreatmentStepDao;
    private LiveData<List<Treatment>> mAllTreatments, mAllRequiredTreatments;
    private LiveData<Treatment> mSpecificTreatment;
    private LiveData<List<TreatmentStep>> mAllTreatmentSteps;
    private LiveData<List<TreatmentStep>> mSpecificTreatmentSteps;
    private LiveData<TreatmentStep> mTreatmentStep;

    private AppRoomDatabase db;

    AppDatabaseRepository(Application application) {

        db = AppRoomDatabase.getDatabase(application);
        mTreatmentDao = db.treatmentDao();
        mTreatmentStepDao = db.treatmentStepsDao();
        mAllTreatments = mTreatmentDao.getAllTreatments();
        mAllRequiredTreatments = mTreatmentDao.getAllRequiredTreatments();
        mAllTreatmentSteps = mTreatmentStepDao.getAllTreatmentSteps();
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
}
