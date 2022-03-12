package com.example.towerdefense;

import android.widget.ImageButton;

public class Cannon1 extends Tower {
    public Player player;

    public Cannon1(Player player, ImageButton button) {
        this.player = player;
        this.button = button;
        int cost = 50;
        double upgradeMultiplier = 1;

        if(player.difficulty.equals("medium")) {
            cost = 75;
            upgradeMultiplier = 1.2;
        }
        else if(player.difficulty.equals("hard")) {
            cost = 100;
            upgradeMultiplier = 1.5;
        }
        //might need to fix imageString
        //super(cost, 1, upgradeMultiplier, 10, 3, "", "../../../../res/drawable/cannon1new.jpg");
        this.cost = cost;
        this.upgradeMultiplier = upgradeMultiplier;
        this.attackSpeed = 10;
        this.attackDamage = 3;
        this.location = "";
        this.imageString = "../../../../res/drawable/cannon1new.jpg";
    }
}
