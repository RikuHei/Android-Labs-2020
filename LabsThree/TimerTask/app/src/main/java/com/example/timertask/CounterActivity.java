package com.example.timertask;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class CounterActivity extends AppCompatActivity {

    TextView timerText;
    CountDownTimer countDownTimer;
    long timeMilliseconds;
    long timeSeconds;
    boolean timer;
    String timerValue;
    int userInputVal;
    int userInputMilliSeconds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        timerText = findViewById(R.id.timeCounter);

        Intent mIntent = getIntent();
        timerValue = mIntent.getStringExtra("userInput");
        userInputVal = Integer.parseInt(timerValue);

        userInputMilliSeconds = userInputVal * 1000;
        timeMilliseconds = TimeUnit.MILLISECONDS.toMillis(userInputMilliSeconds);

        if(timeMilliseconds != 0) {
            activateTimer();
        }
    }

    public void activateTimer() {
        if(timer) {
            stopTimer();
        }else{
            startTimer();
        }
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeMilliseconds = millisUntilFinished;
                timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMilliseconds);
                timerText.setText(String.valueOf(timeSeconds));
            }

            @Override
            public void onFinish() {
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringTone = RingtoneManager.getRingtone(getApplicationContext(), notification);
                ringTone.play();
                Intent intent = new Intent(CounterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }.start();
        timer = true;
    }

    public void stopTimer() {
        countDownTimer.cancel();
        timer = false;
    }
}
