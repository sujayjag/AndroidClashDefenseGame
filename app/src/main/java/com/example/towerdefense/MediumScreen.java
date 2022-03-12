package com.example.towerdefense;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MediumScreen extends AppCompatActivity {
    private TextView money;
    private TextView health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_medium_screen);
        money = findViewById(R.id.money2);
        health = findViewById(R.id.health2);
        money.setText("Money: $750");
        health.setText("Health: 90");
        String nameInputted = getIntent().getStringExtra("nameInputted");

        Player player = new Player("medium", nameInputted);
    }
}
