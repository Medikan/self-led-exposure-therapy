package com.example.medikan.ptsd_treatment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TreatmentCompletionPage extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_completion_page);

        onClickListener();
    }

    public void onClickListener() {

        button = (Button) findViewById(R.id.treatmentCompletionPageBtn);
        final Context context = this;

        button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(context, AvailableStepsPage.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
