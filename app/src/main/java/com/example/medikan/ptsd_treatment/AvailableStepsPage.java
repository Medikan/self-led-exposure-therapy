package com.example.medikan.ptsd_treatment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class AvailableStepsPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private TreatmentStepViewModel mTreatmentStepViewModel;

    private int treatmentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_steps_page);

        Intent intent = getIntent();
        treatmentID = intent.getIntExtra("treatmentID", 1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerAdapter = new AllStepsRecyclerViewAdapter(this, TreatmentDescriptionPage.class);
        recyclerView.setAdapter(recyclerAdapter);

        mTreatmentStepViewModel = ViewModelProviders.of(this).get(TreatmentStepViewModel.class);

        mTreatmentStepViewModel.getSpecificTreatmentSteps(treatmentID).observe(this, new Observer<List<TreatmentStep>>() {

            @Override
            public void onChanged(@Nullable List<TreatmentStep> treatmentSteps) {
                ((AllStepsRecyclerViewAdapter) recyclerAdapter).setTreatmentSteps(treatmentSteps);
            }
        });
    }
}
