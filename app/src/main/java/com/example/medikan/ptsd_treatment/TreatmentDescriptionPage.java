package com.example.medikan.ptsd_treatment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class TreatmentDescriptionPage extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_description_page);

        onClickListener();
    }

    public void onClickListener() {

        button = (Button) findViewById(R.id.treatmentDescriptionPageBtn);
        final Context context = this;

        button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(context, DisplayTimerActivity.class);
                        intent.putExtra("timerValue", 30000);
                        startActivity(intent);
                    }
                }
        );
    }
}
