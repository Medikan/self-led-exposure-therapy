package com.example.medikan.ptsd_treatment;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "treatment_step_table")
public class TreatmentStep {

    @PrimaryKey
    private int mTreatmentStepID;
    @NonNull
    @ColumnInfo(name = "treatmentStep")
    private String mTreatmentStep;
    @ColumnInfo(name = "description")
    private String mDescription;
    @ColumnInfo(name = "isComplete")
    private Boolean mIsComplete;
    @ColumnInfo(name = "isRequired")
    private Boolean mIsRequired;
    @ColumnInfo(name = "priorityLevel")
    private double mPriorityLevel;
    @ColumnInfo(name = "treatmentID")
    private int mTreatmentID;

    public TreatmentStep(@NonNull int treatmentStepID, @NonNull String treatmentStep, String description, double priorityLevel, int treatmentID)
    {
        this.mTreatmentStepID = treatmentStepID;
        this.mTreatmentStep = treatmentStep;
        this.mDescription = description;
        this.mIsComplete = false;
        this.mIsRequired = true;
        this.mPriorityLevel = priorityLevel;
        this.mTreatmentID = treatmentID;
    }

    public int getTreatmentStepID() {return this.mTreatmentStepID;}

    public String getTreatmentStep() {return this.mTreatmentStep;}

    public String getDescription() {return this.mDescription;}

    public Boolean getIsComplete() {return this.mIsComplete;}

    public Boolean getIsRequired() {return this.mIsRequired;}

    public double getPriorityLevel() {return this.mPriorityLevel;}

    public int getTreatmentID() {return this.mTreatmentID;}

    public void setIsComplete(Boolean isComplete) {mIsComplete = isComplete;}

    public void setIsRequired(Boolean isRequired) {mIsRequired = isRequired;}
}
