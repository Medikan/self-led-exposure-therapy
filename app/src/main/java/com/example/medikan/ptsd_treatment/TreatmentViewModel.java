package com.example.medikan.ptsd_treatment;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class TreatmentViewModel extends AndroidViewModel {

    private AppDatabaseRepository mRepository;
    private LiveData<List<Treatment>> mAllTreatments, mAllRequiredTreatments;

    public TreatmentViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AppDatabaseRepository(application);
        mAllTreatments = mRepository.getAllTreatments();
        mAllRequiredTreatments = mRepository.getAllRequiredTreatments();
    }

    LiveData<List<Treatment>> getAllTreatments() {return mAllTreatments;}

    LiveData<List<Treatment>> getAllRequiredTreatments() {return mAllRequiredTreatments;}

    public void insert(Treatment treatment) {mRepository.insert(treatment);}

    public void update(Treatment treatment) {mRepository.update(treatment);}
}
