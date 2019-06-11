package com.example.medikan.ptsd_treatment;

import android.os.AsyncTask;

class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final TreatmentDao mTreatmentDao;
    private final TreatmentStepDao mStepsDao;
    private final TestQuestionDao mTestQuestionDao;

    PopulateDbAsync(AppRoomDatabase db) {
        mTreatmentDao = db.treatmentDao();
        mStepsDao = db.treatmentStepsDao();
        mTestQuestionDao = db.testQuestionDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {

        populateTreatments();
        populateTreatmentSteps();
        populateTestQuestions();

        return null;
    }

    private void populateTreatments() {

        mTreatmentDao.deleteAll();

        for (int i = 1; i < 4; i++) {
            Treatment treatment = new Treatment(i, "treatment_" + i + "_name","treatment_" + i + "_description", false, true,1);
            mTreatmentDao.insert(treatment);
        }
    }

    private void populateTreatmentSteps() {

        mStepsDao.deleteAll();

        int uniqueID = 1;

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {

                TreatmentStep treatmentStep = new TreatmentStep(uniqueID, "treatment_" + i + "_step_" + j + "_name", "treatment_" + i + "_step_" + j + "_description","treatment_" + i + "_step_" + j + "_long_instruction", "treatment_" + i + "_step_" + j + "_short_instruction", 5000, 1, i);
                mStepsDao.insert(treatmentStep);
                uniqueID++;
            }
        }
    }

    private void populateTestQuestions() {

        mTestQuestionDao.deleteAll();

        for (int i = 1; i <= 5; i++) {

            TestQuestion testQuestion = new TestQuestion(i, "Test Question Number " + i, 0);
            mTestQuestionDao.insert(testQuestion);
        }
    }
}
