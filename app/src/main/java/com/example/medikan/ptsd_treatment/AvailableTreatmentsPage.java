package com.example.medikan.ptsd_treatment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AvailableTreatmentsPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[][] allTreatmentsData = {
            {"Potato", "Starchy"},
            {"Lettuce", "Crunchy"},
            {"Square Cheese", "Squarish and Cheesy"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_treatments_page);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerAdapter = new AllTreatmentsRecyclerViewAdapter(this, AvailableStepsPage.class, allTreatmentsData);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
