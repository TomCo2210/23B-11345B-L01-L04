package com.example.a23b_11345b_l01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {
    private MaterialTextView main_LBL_score;
    private MaterialButton main_BTN_yes;
    private MaterialButton main_BTN_no;

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        main_LBL_score.setText(score + "");

        main_BTN_yes.setOnClickListener(v -> increaseScore());
        main_BTN_no.setOnClickListener(v -> decreaseScore());

    }

    private void decreaseScore() {
        this.score -= 100;
        main_LBL_score.setText(score +"");
    }

    private void increaseScore() {
        this.score += 100;
        main_LBL_score.setText(score +"");
    }

    private void findViews() {
        main_LBL_score = findViewById(R.id.main_LBL_score);
        main_BTN_yes = findViewById(R.id.main_BTN_yes);
        main_BTN_no = findViewById(R.id.main_BTN_no);
    }
}