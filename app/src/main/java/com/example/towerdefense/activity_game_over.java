package com.example.towerdefense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_game_over extends AppCompatActivity {
    private Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //test
        setContentView(R.layout.activity_game_over);

        restartButton = (Button) findViewById(R.id.restart_button);

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartActivity();
            }
        });
    }

    public void restartActivity() {
         Intent intent = new Intent(this, MainActivity.class);
         startActivity(intent);
    }
}