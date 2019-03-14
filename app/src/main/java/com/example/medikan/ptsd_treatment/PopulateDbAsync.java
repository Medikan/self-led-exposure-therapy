package com.example.medikan.ptsd_treatment;

import android.os.AsyncTask;

class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final TreatmentDao mDao;

    PopulateDbAsync(AppRoomDatabase db) {
        mDao = db.treatmentDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {

        mDao.deleteAll();
        Treatment treatment = new Treatment(1, "Test Treatment 1","Description for treatment 1",1);
        mDao.insert(treatment);

        treatment = new Treatment(2,"Test Treatment 2", "Description for treatment 2", 1);
        mDao.insert(treatment);

        treatment = new Treatment(3,"Test Treatment 3", "Description for treatment 3", 1);
        mDao.insert(treatment);

        return null;
    }
}
