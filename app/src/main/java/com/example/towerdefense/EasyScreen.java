package com.example.towerdefense;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EasyScreen extends AppCompatActivity {
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
        setContentView(R.layout.activity_easy_screen);
        money = findViewById(R.id.money3);
        health = findViewById(R.id.health3);
        money.setText("Money: $500");
        health.setText("Health: 100");
        String nameInputted = getIntent().getStringExtra("nameInputted");

        Player player = new Player("easy", nameInputted);
    }
}
