package com.example.medikan.ptsd_treatment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LongerRationalePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longer_rationale);
    }

    public void navigateToFormulationPage(View view) {
        Intent intent = new Intent(this, FormulationPage.class);
        startActivity(intent);
    }
}
