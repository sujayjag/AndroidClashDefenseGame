package com.example.towerdefense;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Spinner;

public class HardScreen extends AppCompatActivity {
    private TextView money;
    private TextView health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_hard_screen);
        money = (TextView) findViewById(R.id.money3);
        health = (TextView) findViewById(R.id.health3);
        money.setText("Money: $1000");
        health.setText("Monument Health: 80");
    }
}
