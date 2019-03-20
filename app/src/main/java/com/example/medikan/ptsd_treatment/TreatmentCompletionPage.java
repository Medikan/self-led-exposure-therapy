package com.example.medikan.ptsd_treatment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class TreatmentCompletionPage extends AppCompatActivity {

    private Button button;
    private Intent intent; //TODO redirect intent to AvailableTreatmentsPage if all treatment steps are complete?
    private Context context;
    private int treatmentID;
    private Boolean areAllComplete = true;

    private TreatmentStepViewModel mTreatmentStepViewModel;
    private TreatmentViewModel mTreatmentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_completion_page);

        Intent recievedIntent = getIntent();
        treatmentID  = recievedIntent.getIntExtra("treatmentID", 1);

        updateTreatment();
        onClickListener();
    }

    public void onClickListener() {

        button = (Button) findViewById(R.id.treatmentCompletionPageBtn);
        context = this;

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

    private void updateTreatment() {

        mTreatmentStepViewModel = ViewModelProviders.of(this).get(TreatmentStepViewModel.class);
        mTreatmentViewModel = ViewModelProviders.of(this).get(TreatmentViewModel.class);

        checkTreatmentSteps();

        //if all steps are complete, updates treatment to complete
        if (areAllComplete) {

            mTreatmentViewModel.getSpecificTreatment(treatmentID).observe(this, new Observer<Treatment>() {
                @Override
                public void onChanged(@Nullable Treatment treatment) {

                    treatment.setIsComplete(true);

                    mTreatmentViewModel.update(treatment);
                }
            });
        }
    }

    /**
     * Checks if all the treatment steps for a treatment set are complete, and then updates the treatment
     */
    private void checkTreatmentSteps() {

        mTreatmentStepViewModel.getSpecificTreatmentSteps(treatmentID).observe(this, new Observer<List<TreatmentStep>>() {
            @Override
            public void onChanged(@Nullable List<TreatmentStep> treatmentSteps) {

                for (TreatmentStep treatmentStep: treatmentSteps) {

                    if (!treatmentStep.getIsComplete()) {
                        areAllComplete = false;
                    }
                }
            }
        });
    }
}
