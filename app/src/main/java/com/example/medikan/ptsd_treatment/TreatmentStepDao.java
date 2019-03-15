package com.example.medikan.ptsd_treatment;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TreatmentStepDao {

    @Insert
    void insert(TreatmentStep treatmentStep);

    @Query("DELETE FROM treatment_step_table")
    void deleteAll();

    @Query("SELECT * FROM treatment_step_table ORDER BY mTreatmentStepID ASC")
    LiveData<List<TreatmentStep>> getAllTreatmentSteps();

    @Query("SELECT * FROM treatment_step_table WHERE treatmentID = (:treatmentID) ORDER BY mTreatmentStepID")
    LiveData<List<TreatmentStep>> getSpecificTreatmentSteps(int treatmentID);

    @Query("SELECT * FROM treatment_step_table WHERE mTreatmentStepID = (:treatmentStepID)")
    LiveData<TreatmentStep> getTreatmentStep(int treatmentStepID);
}
