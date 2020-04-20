package com.example.medikan.ptsd_treatment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FormulationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulation_page);
    }

    public void navigateToTreatmentRationalePage(View view) {
        Intent intent = new Intent(this, TreatmentRationalePage.class);
        startActivity(intent);
    }
}
