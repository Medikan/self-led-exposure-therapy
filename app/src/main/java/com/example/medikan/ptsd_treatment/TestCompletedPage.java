package com.example.medikan.ptsd_treatment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestCompletedPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_completed_page);
    }

    public void navigateToLongerRationalePage(View view) {
        Intent intent = new Intent(this, LongerRationalePage.class);
        startActivity(intent);
    }
}
