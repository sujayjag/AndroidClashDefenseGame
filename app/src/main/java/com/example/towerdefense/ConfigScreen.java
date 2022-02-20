package com.example.towerdefense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class ConfigScreen extends AppCompatActivity {
    private Spinner difficulty;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_config_screen);

        submit = (Button) findViewById(R.id.submitButton);
        difficulty = (Spinner) findViewById(R.id.difficultyInput);
        List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Easy");
        spinnerArray.add("Medium");
        spinnerArray.add("Hard");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        difficulty.setAdapter(adapter);

        EditText text = (EditText)findViewById(R.id.nameInput);

        TextView warning = (TextView)findViewById(R.id.warningMessage);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected = difficulty.getSelectedItem().toString();
                String nameInputted = text.getText().toString();
                if (nameInputted.trim().isEmpty()){
                    warning.setText("Please Enter a Valid Name!");
                } else {
                    openGameScreen();
                }
            }
        });
    }

    public void openGameScreen(){
        Intent intent = new Intent(this, GameScreen.class);
        intent.putExtra("difficulty", getDifficulty());
        startActivity(intent);
    }

    public String getDifficulty() {
        return difficulty.getSelectedItem().toString();
    }
}