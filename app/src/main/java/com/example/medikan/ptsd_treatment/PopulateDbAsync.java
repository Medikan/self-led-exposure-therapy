package com.example.medikan.ptsd_treatment;

import android.os.AsyncTask;
import android.util.Log;

import static android.content.ContentValues.TAG;

class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final TreatmentDao mTreatmentDao;
    private final TreatmentStepDao mStepsDao;

    PopulateDbAsync(AppRoomDatabase db) {
        mTreatmentDao = db.treatmentDao();
        mStepsDao = db.treatmentStepsDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {

        populateTreatments();
        populateTreatmentSteps();

        return null;
    }

    private void populateTreatments() {

        mTreatmentDao.deleteAll();
        Treatment treatment = new Treatment(1, "Test Treatment 1","Description for treatment 1", false, true,1);
        mTreatmentDao.insert(treatment);

        treatment = new Treatment(2,"Test Treatment 2", "Description for treatment 2",false, true, 1);
        mTreatmentDao.insert(treatment);

        treatment = new Treatment(3,"Test Treatment 3", "Description for treatment 3",false, true, 1);
        mTreatmentDao.insert(treatment);
    }

    private void populateTreatmentSteps() {

        mStepsDao.deleteAll();

        TreatmentStep treatmentStep = new TreatmentStep(1, "Treatment 1 Step 1", "The first step for the first treatment","Long set of instructions for treatment description page", "Short set of instructions for treatment timer page", 5000, 1, 1);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(2, "Treatment 1 Step 2", "The second step for the first treatment","Long set of instructions for treatment description page", "Short set of instructions for treatment timer page", 5000,1, 1);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(3, "Treatment 1 Step 3", "The third step for the first treatment","Long set of instructions for treatment description page", "Short set of instructions for treatment timer page", 5000,1, 1);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(4, "Treatment 2 Step 1", "The first step for the second treatment","Long set of instructions for treatment description page", "Short set of instructions for treatment timer page", 30000,1, 2);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(5, "Treatment 2 Step 2", "The second step for the second treatment","Long set of instructions for treatment description page", "Short set of instructions for treatment timer page", 30000,1, 2);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(6, "Treatment 2 Step 3", "The third step for the second treatment","Long set of instructions for treatment description page", "Short set of instructions for treatment timer page", 30000,1, 2);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(7, "Treatment 3 Step 1", "The first step for the third treatment","Long set of instructions for treatment description page", "Short set of instructions for treatment timer page", 30000,1, 3);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(8, "Treatment 3 Step 2", "The second step for the third treatment","Long set of instructions for treatment description page", "Short set of instructions for treatment timer page", 30000,1, 3);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(9, "Treatment 3 Step 3", "The third step for the third treatment","Long set of instructions for treatment description page", "Short set of instructions for treatment timer page", 30000,1, 3);
        mStepsDao.insert(treatmentStep);
    }
}
