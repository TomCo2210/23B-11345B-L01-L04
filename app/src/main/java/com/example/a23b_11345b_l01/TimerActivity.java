package com.example.a23b_11345b_l01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

public class TimerActivity extends AppCompatActivity {

    private final int DELAY = 1000;

    private MaterialTextView timer_LBL_time;
    private ExtendedFloatingActionButton timer_FAB_start;
    private ExtendedFloatingActionButton timer_FAB_stop;

    private long startTime = 0;

    private final Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this, DELAY); //Do it again in a second
            updateTimeUI();
        }
    };

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
        startTime = System.currentTimeMillis();
        handler.postDelayed(runnable,0);
    }

    private void stopTime() {
        handler.removeCallbacks(runnable);
    }
}