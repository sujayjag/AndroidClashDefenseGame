package com.example.towerdefense;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HardScreen extends AppCompatActivity {
    private TextView money;
    private TextView health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_hard_screen);
        money = findViewById(R.id.money3);
        health = findViewById(R.id.health3);
        money.setText("Money: $1000");
        health.setText("Monument Health: 80");
    }
}
