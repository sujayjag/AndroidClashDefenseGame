package com.example.towerdefense;

import android.view.View;

import java.lang.reflect.Array;

public class Enemy {
    private int movementSpeed;
    private int damage;
    private int health;
    private String type;
    private int layout;
    private View view;

    //create view for the enemy (image)

    public Enemy(String type, View view) {
        this(type);
        this.setView(view);
    }

    public Enemy(String type) {
        if (type.equals("witch")) {
            setLayout(R.layout.witch);
            movementSpeed = 1000;
            damage = 30;
            health = 100;
        } else if (type.equals("wizard")) {
            setLayout(R.layout.wizard);
            movementSpeed = 1000;
            damage = 50;
            health = 70;
        } else {
            setLayout(R.layout.archer);
            movementSpeed = 1000;
            damage = 10;
            health = 50;
        }
    }



    public void attack(){

    }
    //use Player.setMonumentHealth based on tower's damage
    //Update text
    //Check if momnument is below 0, if it is endGame()
    //Despawn the enemy object

    public void deployEnemy() {
        //Add enemy to screen and start moving
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }
}
