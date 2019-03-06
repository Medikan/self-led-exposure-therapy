package com.example.medikan.ptsd_treatment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AvailableStepsPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[][] allStepsData = {
            {"Step 1", "Grab the lime"},
            {"Step 2", "Put it in the coconut"},
            {"Step 3", "Shake it all up"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_steps_page);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerAdapter = new AllTreatmentsRecyclerViewAdapter(this, TreatmentDescriptionPage.class, allStepsData);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
