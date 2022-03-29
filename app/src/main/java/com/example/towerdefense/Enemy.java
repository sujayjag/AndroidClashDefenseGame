package com.example.towerdefense;

import android.view.View;
import android.widget.TextView;

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
            setMovementSpeed(1000);
            setDamage(30);
            setHealth(100);
        } else if (type.equals("wizard")) {
            setLayout(R.layout.wizard);
            setMovementSpeed(1000);
            setDamage(50);
            setHealth(70);
        } else {
            setLayout(R.layout.archer);
            setMovementSpeed(1000);
            setDamage(10);
            setHealth(50);
        }
    }



    public void attack(Player player, TextView view){
        player.setMonumentHealth(player.getMonumentHealth() - this.damage);
        view.setText("Health: "+player.getMonumentHealth());
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

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
