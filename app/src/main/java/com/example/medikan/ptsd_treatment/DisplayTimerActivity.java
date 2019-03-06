package com.example.medikan.ptsd_treatment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import org.w3c.dom.Text;

/*
    todo add animation to countdown timer. Maybe circle like Apple timer
    todo make sure this class can be used for any treatment/timer combo
    todo find a way to save progress. Once the treatment has been finished, log it permanently with options to redo
 */
public class DisplayTimerActivity extends AppCompatActivity {

    private TextView countdownTimer;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_timer);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        int timerValue = intent.getIntExtra("timerValue", 15000); //the amount of time the treatment is for, in milliseconds

        countdownTimer = (TextView)findViewById(R.id.countdownTimer);
        countdownTimer.setText(convertCountdownTimer(timerValue));

        setupTimer(timerValue); //sets up the timer for this activity

        onClickListenerButton(timerValue); //creates the onclick listener for the button
    }

    /**
     * Sets up the onclick listener for the button. Starts and resets the timer based on the text of the button
     * @param timerValue the ammount of time the treatment is for, in milliseconds
     */
    public void onClickListenerButton(final int timerValue) {

        final Button btnStart = (Button) findViewById(R.id.btnStart);

        btnStart.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        //Checks to see if the text on the button is the localized string "Start"; if it is, then it starts the timer
                        if(btnStart.getText().toString().equals(getString(R.string.countdownTimerStartBtn))) {
                            timer.start();
                            btnStart.setText(R.string.countdownTimerStopBtn); //sets button text to "Stop"
                        }
                        else if(btnStart.getText().toString().equals(getString(R.string.countdownTimerStopBtn))) {
                            timer.cancel();
                            btnStart.setText(R.string.countdownTimerStartBtn); //sets button text to "Start"
                            countdownTimer.setText(convertCountdownTimer(timerValue));
                        }
                    }
                }
        );
    }

    /**
     * sets up the timer for start/stopping by the listener
     * WARNING converting from long to int may mess up some larger numbers. Might be a bug here in the future
     * @param timerValue
     */
    private void setupTimer(int timerValue) {

        final Context context = this;

        timer = new CountDownTimer(timerValue, 1000) {

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onTick(long millisUntilFinished) {
                countdownTimer.setText(convertCountdownTimer(Math.toIntExact(millisUntilFinished)));
            }

            public void onFinish() {
                Intent intent = new Intent(context, TreatmentCompletionPage.class);
                startActivity(intent);
            }
        };
    }

    /**
     * Converts the time in milliseconds into a nicely readable format mm:ss
     * @param timeInMilliseconds the time to convert to mm:ss format in milliseconds
     * @return the mm:ss in string format
     */
    private String convertCountdownTimer(int timeInMilliseconds) {

        int timeInSeconds = timeInMilliseconds / 1000;
        int minutes = timeInSeconds / 60;
        int seconds = timeInSeconds % 60;

        return Integer.toString(minutes) + ":" + ( seconds < 10 ? "0" + Integer.toString(seconds) : Integer.toString(seconds));
    }
}
