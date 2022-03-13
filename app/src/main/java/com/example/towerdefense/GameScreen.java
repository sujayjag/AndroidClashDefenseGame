package com.example.towerdefense;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameScreen extends AppCompatActivity {
    private TextView money;
    private TextView health;
    private ImageButton cannon1;
    private ImageButton cannon2;
    private ImageButton cannon3;
    private ImageButton place1ImageButton;
    private ImageButton place2ImageButton;
    private ImageButton place3ImageButton;
    private Button cancelButton;
    private ArrayList<Place> places;
    private Place place1;
    private Place place2;
    private Place place3;
    private Tower cannonSelected;
    private Player player;
    private int layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        String nameInputted = getIntent().getStringExtra("nameInputted");
        String difficulty = getIntent().getStringExtra("difficulty");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        player = new Player(difficulty, nameInputted);

        if (player.getDifficulty().equals("easy")) {
            layout = R.layout.activity_easy_screen;
        } else if (player.getDifficulty().equals("medium")) {
            layout = R.layout.activity_medium_screen;
        } else {
            layout = R.layout.activity_hard_screen;
        }

        setContentView(layout);
        money = findViewById(R.id.money3);
        health = findViewById(R.id.health3);


        money.setText("Money: " + player.getBalance());
        health.setText("Health: " + player.getMonumentHealth());

        cannon1 = (ImageButton) findViewById(R.id.cannon1);
        cannon2 = (ImageButton) findViewById(R.id.cannon2);
        cannon3 = (ImageButton) findViewById(R.id.cannon3);

        cancelButton = (Button) findViewById(R.id.cancel);
        cancelButton.setVisibility(View.GONE);

        Cannon1 cannon1Object = new Cannon1(player, cannon1);
        Cannon2 cannon2Object = new Cannon2(player, cannon2);
        Cannon3 cannon3Object = new Cannon3(player, cannon3);

        place1ImageButton = (ImageButton) findViewById(R.id.place1);
        place2ImageButton = (ImageButton) findViewById(R.id.place2);
        place3ImageButton = (ImageButton) findViewById(R.id.place3);

        place1 = new Place(place1ImageButton);
        place2 = new Place(place2ImageButton);
        place3 = new Place(place3ImageButton);

        places = new ArrayList<>();
        places.add(place1);
        places.add(place2);
        places.add(place3);


        cannon1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (places.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All Places are Filled",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Shop.buyTower(cannon1Object, player)) {
                    placement(R.drawable.cannon1newnew);
                    updateMoney(player.getBalance());
                    cannonSelected = cannon1Object;
                } else {
                    insufficientFunds();
                }
            }
        });

        cannon2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (places.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All Places are Filled",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Shop.buyTower(cannon2Object, player)) {
                    placement(R.drawable.cannon2newnew);
                    updateMoney(player.getBalance());
                    cannonSelected = cannon2Object;
                } else {
                    insufficientFunds();
                }
            }
        });


        cannon3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (places.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All Places are Filled",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Shop.buyTower(cannon3Object, player)) {
                    placement(R.drawable.cannon3new);
                    updateMoney(player.getBalance());
                    cannonSelected = cannon3Object;
                } else {
                    insufficientFunds();
                }
            }
        });


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cannonSelected != null) {
                    visibilityOff();
                }
                cancelButton.setVisibility(View.GONE);
            }
        });
    }

    public void placement(int imgRes) {
        Toast.makeText(getApplicationContext(), "Select Location",
                Toast.LENGTH_SHORT).show();
        for (Place b : places) {
            if (!b.isVisible()) {
                b.getPlace().setVisibility(View.VISIBLE);
                b.setVisible(true);
            }
        }
        cancelButton.setVisibility(View.VISIBLE);

        place1ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                places.remove(place1);
                visibilityOff();
                placeTower(place1ImageButton, imgRes);
            }
        });

        place2ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                places.remove(place2);
                visibilityOff();
                placeTower(place2ImageButton, imgRes);
            }
        });

        place3ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                places.remove(place3);
                visibilityOff();
                placeTower(place3ImageButton, imgRes);
            }
        });

    }

    private void visibilityOff() {
        for (Place b : places) {
            b.getPlace().setVisibility(View.GONE);
            b.setVisible(false);
        }
    }

    private boolean placeTower(ImageButton button, int imgRes) {
        Integer resource = (Integer) button.getTag();
        if (resource != null) {
            towerAlreadyExists();
            return false;
        }

        button.setBackgroundColor(Color.TRANSPARENT);
        button.setImageResource(imgRes);
        button.setScaleType(ImageView.ScaleType.FIT_START);
        button.setTag(imgRes);
        cancelButton.setVisibility(View.GONE);
        player.updateBalance(-1 * cannonSelected.getCost());
        updateMoney(player.getBalance());
        return true;
    }

    private void insufficientFunds() {
        Toast.makeText(getApplicationContext(), "Insufficient Funds to Buy Tower",
                Toast.LENGTH_LONG).show();
    }

    private void towerAlreadyExists() {
        Toast.makeText(getApplicationContext(), "Tower already exists in this place!",
                Toast.LENGTH_LONG).show();
    }

    //hello
    private void updateMoney(int mon) {
        money.setText("Money: " + mon);
    }


}