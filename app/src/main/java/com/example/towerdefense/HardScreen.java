package com.example.towerdefense;

import android.media.Image;
import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HardScreen extends AppCompatActivity {
    private TextView money;
    private TextView health;
    private ImageButton cannon1;
    private ImageButton cannon2;
    private ImageButton cannon3;
    private ImageButton place1ImageButton;
    private ImageButton place2ImageButton;
    private ImageButton place3ImageButton;
    private ArrayList<Place> places;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        String nameInputted = getIntent().getStringExtra("nameInputted");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_hard_screen);
        money = findViewById(R.id.money3);
        health = findViewById(R.id.health3);


        Player player = new Player("hard", nameInputted);

        money.setText("Money: " +  player.balance);
        health.setText("Monument Health: 80");

        cannon1 = (ImageButton) findViewById(R.id.cannon1);
        cannon2 = (ImageButton) findViewById(R.id.cannon2);
        cannon3 = (ImageButton) findViewById(R.id.cannon3);

        place1ImageButton = (ImageButton) findViewById(R.id.place1);
        place2ImageButton = (ImageButton) findViewById(R.id.place2);
        place3ImageButton = (ImageButton) findViewById(R.id.place3);

        Place place1 = new Place(place1ImageButton);
        Place place2 = new Place(place2ImageButton);
        Place place3 = new Place(place3ImageButton);

        places.add(place1);
        places.add(place2);
        places.add(place3);


        //cannon1 in buyTower and placement refers to cannon1 class, not cannon1 imagebutton
        //change later
        cannon1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Shop.buyTower(cannon1, player)) {
                    placement(R.drawable.cannon1new);
                } else {
                    insufficientFunds();
                }
            }
        });

        cannon2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Shop.buyTower(cannon2, player)) {
                    placement(R.drawable.cannon2new);
                } else {
                    insufficientFunds();
                }
            }
        });


        cannon3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Shop.buyTower(cannon3, player)) {
                    placement(R.drawable.cannon3new);
                } else {
                    insufficientFunds();
                }
            }
        });


    }

    public void placement (int imgRes){
        for (Place b : places) {
            if (!b.visible) {
                b.place.setVisibility(View.VISIBLE);
                b.visible = true;
            }
        }

        place1ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visibilityOff();
                placeTower(place1ImageButton, imgRes);
            }
        });

        place2ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visibilityOff();
                placeTower(place2ImageButton, imgRes);
            }
        });

        place3ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visibilityOff();
                placeTower(place3ImageButton, imgRes);
            }
        });

    }

    private void visibilityOff () {
        for (Place b : places) {
            b.place.setVisibility(View.GONE);
            b.visible = false;
        }
    }

    private void placeTower (ImageButton button, int imgRes){
        button.setImageResource(imgRes);
    }

    private void insufficientFunds () {
        //create insufficient funds dialog
    }
}

