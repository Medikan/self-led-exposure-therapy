package com.example.medikan.ptsd_treatment;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AppDatabaseRepository {

    private TreatmentDao mTreatmentDao;
    private LiveData<List<Treatment>> mAllTreatments;

    AppDatabaseRepository(Application application) {

        AppRoomDatabase db = AppRoomDatabase.getDatabase(application);
        mTreatmentDao = db.treatmentDao();
        mAllTreatments = mTreatmentDao.getAllTreatments();
    }

    LiveData<List<Treatment>> getAllTreatments() {

        return mAllTreatments;
    }

    public void insert (Treatment treatment) {

        new insertAsyncTask(mTreatmentDao).execute(treatment);
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
}
