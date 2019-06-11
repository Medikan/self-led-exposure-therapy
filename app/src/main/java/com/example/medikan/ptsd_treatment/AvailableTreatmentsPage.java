package com.example.medikan.ptsd_treatment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class AvailableTreatmentsPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private TreatmentViewModel mTreatmentViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_treatments_page);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerAdapter = new AllTreatmentsRecyclerViewAdapter(this, AvailableStepsPage.class);
        recyclerView.setAdapter(recyclerAdapter);

        mTreatmentViewModel = ViewModelProviders.of(this).get(TreatmentViewModel.class);

        mTreatmentViewModel.getAllRequiredTreatments().observe(this, new Observer<List<Treatment>>() {
            @Override
            public void onChanged(@Nullable List<Treatment> treatments) {
                ((AllTreatmentsRecyclerViewAdapter) recyclerAdapter).setTreatments(treatments);
            }
        });
    }
}
