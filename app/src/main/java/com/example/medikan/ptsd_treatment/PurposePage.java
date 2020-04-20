package com.example.medikan.ptsd_treatment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PurposePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purpose_of_app_page);
    }

    public void navigateToConsentPage(View view) {
        Intent intent = new Intent(this, ConsentPage.class);
        startActivity(intent);
    }
}
