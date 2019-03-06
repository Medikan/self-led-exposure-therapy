package com.example.medikan.ptsd_treatment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_page);
    }

    public void navigateToTestCompletedPage(View view) {
        Intent intent = new Intent(this, TestCompletedPage.class);
        startActivity(intent);
    }
}
