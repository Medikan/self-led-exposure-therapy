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
        Treatment treatment = new Treatment(1, "treatment_1_name","treatment_1_description", false, true,1);
        mTreatmentDao.insert(treatment);

        treatment = new Treatment(2,"treatment_2_name", "treatment_2_description",false, true, 1);
        mTreatmentDao.insert(treatment);

        treatment = new Treatment(3,"treatment_3_name", "treatment_3_description",false, true, 1);
        mTreatmentDao.insert(treatment);
    }

    private void populateTreatmentSteps() {

        mStepsDao.deleteAll();

        TreatmentStep treatmentStep = new TreatmentStep(1, "treatment_1_step_1_name", "treatment_1_step_1_description","treatment_1_step_1_long_instruction", "treatment_1_step_1_short_instruction", 5000, 1, 1);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(2, "treatment_1_step_2_name", "treatment_1_step_2_description","treatment_1_step_2_long_instruction", "treatment_1_step_2_short_instruction", 5000,1, 1);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(3, "treatment_1_step_3_name", "treatment_1_step_3_description","treatment_1_step_3_long_instruction", "treatment_1_step_3_short_instruction", 5000,1, 1);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(4, "treatment_2_step_1_name", "treatment_2_step_1_description","treatment_2_step_1_long_instruction", "treatment_2_step_1_short_instruction", 30000,1, 2);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(5, "treatment_2_step_2_name", "treatment_2_step_2_description","treatment_2_step_2_long_instruction", "treatment_2_step_2_short_instruction", 30000,1, 2);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(6, "treatment_2_step_3_name", "treatment_2_step_3_description","treatment_2_step_3_long_instruction", "treatment_2_step_3_short_instruction", 30000,1, 2);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(7, "treatment_3_step_1_name", "Ttreatment__step_1_description","treatment_3_step_1_long_instruction", "treatment_3_step_1_short_instruction", 30000,1, 3);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(8, "treatment_3_step_2_name", "treatment_3_step_2_description","treatment_3_step_2_long_instruction", "treatment_3_step_2_short_instruction", 30000,1, 3);
        mStepsDao.insert(treatmentStep);

        treatmentStep = new TreatmentStep(9, "treatment_3_step_3_name", "treatment_3_step_3_description","treatment_3_step_3_long_instruction", "treatment_3_step_3_short_instruction", 30000,1, 3);
        mStepsDao.insert(treatmentStep);
    }
}
