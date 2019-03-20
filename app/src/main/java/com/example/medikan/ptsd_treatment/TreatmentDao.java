package com.example.medikan.ptsd_treatment;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TreatmentDao {

    @Insert
    void insert(Treatment treatment);

    @Query("DELETE FROM treatment_table")
    void deleteAll();

    @Query("SELECT * FROM treatment_table ORDER BY mTreatmentID ASC")
    LiveData<List<Treatment>> getAllTreatments();

    @Query("SELECT * FROM treatment_table WHERE isRequired ORDER BY isComplete ASC, priorityLevel DESC")
    LiveData<List<Treatment>> getAllRequiredTreatments();

    @Query("SELECT * FROM treatment_table WHERE mTreatmentID = (:treatmentID)")
    LiveData<Treatment> getSpecificTreatment(int treatmentID);

    @Update
    void updateTreatments(Treatment... treatments);
}
