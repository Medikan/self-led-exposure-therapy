package com.example.medikan.ptsd_treatment;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "treatment_table")
public class Treatment {

    @PrimaryKey
    private int mTreatmentID;
    @NonNull
    @ColumnInfo(name = "treatment")
    private String mTreatment;
    @ColumnInfo(name = "description")
    private String mDescription;
    @ColumnInfo(name = "isComplete")
    private Boolean mIsComplete;
    @ColumnInfo(name = "isRequired")
    private Boolean mIsRequired;
    @ColumnInfo(name = "priorityLevel")
    private double mPriorityLevel;

    public Treatment(@NonNull int treatmentID, @NonNull String treatment, String description, Boolean isComplete, Boolean isRequired, double priorityLevel)
    {
        this.mTreatmentID = treatmentID;
        this.mTreatment = treatment;
        this.mDescription = description;
        this.mIsComplete = isComplete;
        this.mIsRequired = isRequired;
        this.mPriorityLevel = priorityLevel;
    }

    public int getTreatmentID() {return this.mTreatmentID;}

    public String getTreatment() {return this.mTreatment;}

    public String getDescription() {return this.mDescription;}

    public Boolean getIsComplete() {return this.mIsComplete;}

    public Boolean getIsRequired() {return this.mIsRequired;}

    public double getPriorityLevel() {return this.mPriorityLevel;}

    public void setIsComplete(Boolean isComplete) {mIsComplete = isComplete;}

    public void setIsRequired(Boolean isRequired) {mIsRequired = isRequired;}

    public void setPriorityLevel(Double priorityLevel) {mPriorityLevel = priorityLevel;}
}
