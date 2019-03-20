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
    @ColumnInfo(name = "longInstruction")
    private String mLongInstruction;
    @ColumnInfo(name = "shortInstruction")
    private String mShortInstruction;
    @ColumnInfo(name = "timerValue")
    private int mTimerValue;
    @ColumnInfo(name = "isComplete")
    private Boolean mIsComplete;
    @ColumnInfo(name = "isRequired")
    private Boolean mIsRequired;
    @ColumnInfo(name = "priorityLevel")
    private double mPriorityLevel;
    @ColumnInfo(name = "treatmentID")
    private int mTreatmentID;

    public TreatmentStep(@NonNull int treatmentStepID,@NonNull String treatmentStep, String description, String longInstruction, String shortInstruction, int timerValue, double priorityLevel, int treatmentID)
    {
        this.mTreatmentStepID = treatmentStepID;
        this.mTreatmentStep = treatmentStep;
        this.mDescription = description;
        this.mLongInstruction = longInstruction;
        this.mShortInstruction = shortInstruction;
        this.mTimerValue = timerValue;
        this.mIsComplete = false;
        this.mIsRequired = true;
        this.mPriorityLevel = priorityLevel;
        this.mTreatmentID = treatmentID;
    }

    public int getTreatmentStepID() {return this.mTreatmentStepID;}

    public String getTreatmentStep() {return this.mTreatmentStep;}

    public String getDescription() {return this.mDescription;}

    public String getLongInstruction() {return this.mLongInstruction;}

    public String getShortInstruction() {return this.mShortInstruction;}

    public int getTimerValue() {return this.mTimerValue;}

    public Boolean getIsComplete() {return this.mIsComplete;}

    public Boolean getIsRequired() {return this.mIsRequired;}

    public double getPriorityLevel() {return this.mPriorityLevel;}

    public int getTreatmentID() {return this.mTreatmentID;}

    public void setIsComplete(Boolean isComplete) {mIsComplete = isComplete;}

    public void setIsRequired(Boolean isRequired) {mIsRequired = isRequired;}

    public void setPriorityLevel(double priorityLevel) {mPriorityLevel = priorityLevel;}
}
