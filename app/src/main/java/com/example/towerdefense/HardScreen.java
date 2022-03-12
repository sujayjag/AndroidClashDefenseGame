package com.example.towerdefense;

import android.media.Image;
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
    private Button place1;
    private Button place2;
    private Button place3;
    private boolean VisibleFlag = false;
    private ArrayList<Place> places;
    private ArrayList<ImageButton> hiddenButtons;
    private ImageButton buttonPressed;
    private Button placePressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_hard_screen);
        money = findViewById(R.id.money3);
        health = findViewById(R.id.health3);
        money.setText("Money: $1000");
        health.setText("Monument Health: 80");

        ImageButton cannon1place1 = (ImageButton) findViewById(R.id.cannon1place1);
        ImageButton cannon2place1 = (ImageButton) findViewById(R.id.cannon2place1);
        ImageButton cannon3place1 = (ImageButton) findViewById(R.id.cannon3place1);

        ImageButton cannon1place2 = (ImageButton) findViewById(R.id.cannon1place2);
        ImageButton cannon2place2 = (ImageButton) findViewById(R.id.cannon2place2);
        ImageButton cannon3place2 = (ImageButton) findViewById(R.id.cannon3place2);

        ImageButton cannon1place3 = (ImageButton) findViewById(R.id.cannon1place3);
        ImageButton cannon2place3 = (ImageButton) findViewById(R.id.cannon2place3);
        ImageButton cannon3place3 = (ImageButton) findViewById(R.id.cannon3place3);

        cannon1 = (ImageButton) findViewById(R.id.cannon1);
        cannon2 = (ImageButton) findViewById(R.id.cannon2);
        cannon3 = (ImageButton) findViewById(R.id.cannon3);

        place1 = (Button) findViewById(R.id.place1);
        place2 = (Button) findViewById(R.id.place2);
        place3 = (Button) findViewById(R.id.place3);

        Place Place1 = new Place(place1, cannon1place1, cannon2place1, cannon3place1);
        Place Place2 = new Place(place2, cannon1place2, cannon2place2, cannon3place2);
        Place Place3 = new Place(place3, cannon1place3, cannon2place3, cannon3place3);


        places = new ArrayList<>();
        places.add(Place1);
        places.add(Place2);
        places.add(Place3);


        for (Place b: places) {
            b.place.setVisibility(View.GONE);
        }

        cannon1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if (VisibleFlag) {
                    for (Place b: places) {
                        b.place.setVisibility(View.GONE);
                    }
                    VisibleFlag = false;
                } else {
                    for (Place b: places) {
                        b.place.setVisibility(View.VISIBLE);
                    }
                    VisibleFlag = true;
                }
                buttonPressed = cannon1;

            }
        });

        cannon3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if (VisibleFlag) {
                    for (Place b: places) {
                        b.place.setVisibility(View.GONE);
                    }
                    VisibleFlag = false;
                } else {
                    for (Place b: places) {
                        b.place.setVisibility(View.VISIBLE);
                    }
                    VisibleFlag = true;
                }
                buttonPressed = cannon2;

            }
        });

        cannon3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if (VisibleFlag) {
                    for (Place b: places) {
                        b.place.setVisibility(View.GONE);
                    }
                    VisibleFlag = false;
                } else {
                    for (Place b: places) {
                        b.place.setVisibility(View.VISIBLE);
                    }
                    VisibleFlag = true;
                }
                buttonPressed = cannon3;

            }
        });


        place1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                placePressed = place1;
                displayTower(buttonPressed, place1);
                places.remove(Place1);
                for (Place b: places) {
                    b.place.setVisibility(View.GONE);
                }
            }
        });

        place2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                placePressed = place2;
                displayTower(buttonPressed, place2);
                places.remove(Place2);
                for (Place b: places) {
                    b.place.setVisibility(View.GONE);
                }
            }
        });    

        place3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                placePressed = place3;
                displayTower(buttonPressed, place3);
                places.remove(Place3);
                for (Place b: places) {
                    b.place.setVisibility(View.GONE);
                }

            }
        });
    }

    private void displayTower(ImageButton cannon, Button pressed) {
        for (Place b: places) {
            if (b.place.equals(pressed)) {
                //set visibility to true of cannon
               if (cannon.equals(cannon1)) {
                   b.cannon1.setVisibility(View.VISIBLE);
               } else if (cannon.equals(cannon2)) {
                   b.cannon2.setVisibility(View.VISIBLE);
               } else {
                   b.cannon3.setVisibility(View.VISIBLE);
               }
            }
        }
    }

}
