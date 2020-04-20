package com.example.medikan.ptsd_treatment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RationalePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rational_page);
    }

    public void navigateToPurposePage(View view) {
        Intent intent = new Intent(this, PurposePage.class);
        startActivity(intent);
    }
}
