package com.example.a23b_11345b_l01;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity2 extends AppCompatActivity {

    private final int DELAY = 1000;

    private MaterialTextView timer_LBL_time;
    private ExtendedFloatingActionButton timer_FAB_start;
    private ExtendedFloatingActionButton timer_FAB_stop;

    private long startTime = 0;

    private Timer timer;

    private void updateTimeUI() {
        Log.d("Timer Count:", "" + System.currentTimeMillis());
        long millis = System.currentTimeMillis() - startTime;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds %= 60;
        int hours = minutes / 60;
        minutes %= 60;
        hours %= 24;

        timer_LBL_time.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        findViews();
        initViews();
    }

    private void findViews() {
        timer_LBL_time = findViewById(R.id.timer_LBL_time);
        timer_FAB_start = findViewById(R.id.timer_FAB_start);
        timer_FAB_stop = findViewById(R.id.timer_FAB_stop);
    }

    private void initViews() {
        timer_FAB_start.setOnClickListener(v -> startTime());
        timer_FAB_stop.setOnClickListener(v -> stopTime());
    }


    private void startTime() {
        if (timer == null) {
            startTime = System.currentTimeMillis();
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Log.d("run in StartTime:", "" + System.currentTimeMillis() + " Thread name: " + Thread.currentThread().getName());
                    runOnUiThread(() -> {
                        Log.d("run in StartTime:", "" + System.currentTimeMillis() + " Thread name: " + Thread.currentThread().getName());
                        updateTimeUI();
                    });
                }
            }, 0, DELAY);
        }
    }

    private void stopTime() {
        if (timer != null)
            timer.cancel();
        timer = null;
    }
}