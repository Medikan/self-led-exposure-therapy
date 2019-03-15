package com.example.medikan.ptsd_treatment;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class TreatmentStepViewModel extends AndroidViewModel {

    private AppDatabaseRepository mRepository;
    private LiveData<List<TreatmentStep>> mAllTreatmentSteps;
    private LiveData<List<TreatmentStep>> mSpecificTreatmentSteps;
    private LiveData<TreatmentStep> mTreatmentStep;

    public TreatmentStepViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AppDatabaseRepository(application);
        mAllTreatmentSteps = mRepository.getAllTreatmentSteps();
    }

    LiveData<List<TreatmentStep>> getAllTreatmentSteps() {return mAllTreatmentSteps;}

    LiveData<List<TreatmentStep>> getSpecificTreatmentSteps(int treatmentID) {

        mSpecificTreatmentSteps = mRepository.getSpecificTreatmentSteps(treatmentID);

        return mSpecificTreatmentSteps;
    }

    LiveData<TreatmentStep> getTreatmentStep(int treatmentStepID) {

        mTreatmentStep = mRepository.getTreatmentStep(treatmentStepID);

        return mTreatmentStep;
    }

    public void insert(TreatmentStep treatmentStep) {mRepository.insert(treatmentStep);}
}
