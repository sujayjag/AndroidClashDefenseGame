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

public class MediumScreen extends AppCompatActivity {
    private TextView money;
    private TextView health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_medium_screen);
        money = (TextView) findViewById(R.id.money2);
        health = (TextView) findViewById(R.id.health2);
        money.setText("Money: $750");
        health.setText("Monument Health: 90");
    }
}
