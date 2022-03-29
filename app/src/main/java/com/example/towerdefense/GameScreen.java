package com.example.towerdefense;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Path;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameScreen extends AppCompatActivity {
    private TextView money;
    private TextView health;
    private TextView cannon1Cost;
    private TextView cannon2Cost;
    private TextView cannon3Cost;
    private ImageButton cannon1;
    private ImageButton cannon2;
    private ImageButton cannon3;
    private ImageView img;
    private ImageButton place1ImageButton;
    private ImageButton place2ImageButton;
    private ImageButton place3ImageButton;
    private ImageButton place4ImageButton;
    private ImageButton place5ImageButton;
    private Button cancelButton;
    private Button startCombatButton;
    private ArrayList<Place> places;
    private Place place1;
    private Place place2;
    private Place place3;
    private Place place4;
    private Place place5;
    private Tower cannonSelected;
    private Player player;
    private int layout;
    private Path path;

    private ImageView witch;
    private ImageView wizard;
    private ImageView archer;

    private RelativeLayout layoutParent;
    private LayoutInflater layoutInflater;
    private View newView;

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
        img = (ImageView) findViewById(R.id.imageView5);

        //System.out.println(img.getDrawable().getIntrinsicWidth());
        //Difficulty difficultyObj = new Difficulty(player, img.getDrawable().getIntrinsicWidth(), img.getDrawable().getIntrinsicHeight());
        Difficulty difficultyObj = new Difficulty(player);

        layout = difficultyObj.getLayout();
        path = difficultyObj.getPath();


        setContentView(layout);
        money = findViewById(R.id.money3);
        health = findViewById(R.id.health3);


        money.setText("Money: " + player.getBalance());
        health.setText("Health: " + player.getMonumentHealth());

        cannon1 = (ImageButton) findViewById(R.id.cannon1);
        cannon2 = (ImageButton) findViewById(R.id.cannon2);
        cannon3 = (ImageButton) findViewById(R.id.cannon3);


        //System.out.println(img.getDrawable().getIntrinsicWidth());

        cancelButton = (Button) findViewById(R.id.cancel);
        cancelButton.setVisibility(View.GONE);

        Cannon1 cannon1Object = new Cannon1(player, cannon1);
        Cannon2 cannon2Object = new Cannon2(player, cannon2);
        Cannon3 cannon3Object = new Cannon3(player, cannon3);

        cannon1Cost = (TextView) findViewById(R.id.cannon1cost);
        cannon2Cost = (TextView) findViewById(R.id.cannon2cost);
        cannon3Cost = (TextView) findViewById(R.id.cannon3cost);

        cannon1Cost.setText("Cost: " + cannon1Object.getCost());
        cannon2Cost.setText("Cost: " + cannon2Object.getCost());
        cannon3Cost.setText("Cost: " + cannon3Object.getCost());

        place1ImageButton = (ImageButton) findViewById(R.id.place1);
        place2ImageButton = (ImageButton) findViewById(R.id.place2);
        place3ImageButton = (ImageButton) findViewById(R.id.place3);
        place4ImageButton = (ImageButton) findViewById(R.id.place4);
        place5ImageButton = (ImageButton) findViewById(R.id.place5);

        place1 = new Place(place1ImageButton);
        place2 = new Place(place2ImageButton);
        place3 = new Place(place3ImageButton);
        place4 = new Place(place4ImageButton);
        place5 = new Place(place5ImageButton);

        places = new ArrayList<>();
        places.add(place1);
        places.add(place2);
        places.add(place3);
        places.add(place4);
        places.add(place5);


        witch = (ImageView) findViewById(R.id.witch);
        witch.setVisibility(View.GONE);
        wizard = (ImageView) findViewById(R.id.wizard);
        wizard.setVisibility(View.GONE);
        archer = (ImageView) findViewById(R.id.archer);
        archer.setVisibility(View.GONE);

        layoutParent = (RelativeLayout) findViewById(R.id.RelativeLayout);

        layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);


        startCombatButton = (Button) findViewById(R.id.startCombat);

        startCombatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCombatButton.setVisibility(View.GONE);
                //depends on level
                int numOfEnemies = 10;
                ArrayList<View> witches = new ArrayList<>();

                final Handler handler = new Handler();
                Runnable task = new Runnable() {
                    int i = 0;
                    @Override
                    public void run() {


                        newView = layoutInflater.inflate(R.layout.witch, null, false);
                        newView.setLayoutParams(new RelativeLayout.LayoutParams(180, 200));

                        //hardcoded
                        newView.setX(280);
                        newView.setY(60);


                        newView.setVisibility(View.VISIBLE);
                        layoutParent.addView(newView);
                        witches.add(newView);
                        ObjectAnimator animator = ObjectAnimator.ofFloat(newView, View.X, View.Y, path);
                        //duration should be movementSpeed of enemy object
                        animator.setDuration(3000);
                        animator.start();
                        // for each value in witches
                        // check if witch.x and witch.y is equal to end coordinates
                        // if code: delete witch from arraylist and reduce monument health
                        if (player.getMonumentHealth() > 0) {
                            for (View witch: witches) {
                                System.out.println(witch.getX() + " " + witch.getY());
                                if (witch.getX() == 1242.0 && witch.getY() == 1215.0) {
                                    System.out.println("a");
                                    //witches.remove(witch);

                                    if (witch.getVisibility() == View.VISIBLE) {
                                        player.setMonumentHealth(player.getMonumentHealth() - 10);
                                        health.setText("Health: "+player.getMonumentHealth());
                                    }
                                    witch.setVisibility(View.GONE);
                                }
                            }
                        } else {
                            // game screen
                        }


                        i++;
                        if (i < numOfEnemies){
                            handler.postDelayed(this, 3050);
                        }
                    }
                };
                handler.post(task);


                }

        });



        cannon1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (places.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All Places are Filled",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Shop.buyTower(cannon1Object, player)) {
                    placement(R.drawable.cannon1new);
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
                    placement(R.drawable.cannon3newnew);
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

        place4ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                places.remove(place4);
                visibilityOff();
                placeTower(place4ImageButton, imgRes);
            }
        });

        place5ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                places.remove(place5);
                visibilityOff();
                placeTower(place5ImageButton, imgRes);
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

    private void updateMoney(int mon) {
        money.setText("Money: " + mon);
    }

    public static float pxFromDp(double d) {
        float scale = 432f;
        float dp = (float) d;
        float px = dp * (scale/160);
        return px;
    }


}
