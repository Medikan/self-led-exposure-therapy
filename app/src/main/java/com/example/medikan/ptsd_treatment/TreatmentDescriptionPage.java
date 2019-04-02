package com.example.medikan.ptsd_treatment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class TreatmentDescriptionPage extends AppCompatActivity {

    private Button button;
    private TextView title;
    private TextView description;
    private int treatmentStepID;
    private LiveData<TreatmentStep> treatmentStep;

    private Intent intent;

    private TreatmentStepViewModel mTreatmentStepViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_description_page);

        Intent receivedIntent = getIntent();
        treatmentStepID = receivedIntent.getIntExtra("treatmentStepID", 1);


        intent = new Intent(this, DisplayTimerActivity.class);

        onClickListener();
        setupText(treatmentStepID);
    }

    public void setupText(final int treatmentStepID) {

        title = (TextView) findViewById(R.id.treatmentTitle);
        description = (TextView) findViewById(R.id.treatmentDescription);

        mTreatmentStepViewModel = ViewModelProviders.of(this).get(TreatmentStepViewModel.class);

        mTreatmentStepViewModel.getTreatmentStep(treatmentStepID).observe(this, new Observer<TreatmentStep>() {
            @Override
            public void onChanged(@Nullable TreatmentStep treatmentStep) {
                title.setText(getResources().getString(getResources().getIdentifier(treatmentStep.getTreatmentStep(), "string", "com.example.medikan.ptsd_treatment")));
                description.setText(getResources().getString(getResources().getIdentifier(treatmentStep.getLongInstruction(), "string", "com.example.medikan.ptsd_treatment")));

                intent.putExtra("treatmentStepID", treatmentStep.getTreatmentStepID());
            }
        });


    }

    public void onClickListener() {

        button = (Button) findViewById(R.id.treatmentDescriptionPageBtn);
        final Context context = this;

        button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        startActivity(intent);
                    }
                }
        );
    }
}
