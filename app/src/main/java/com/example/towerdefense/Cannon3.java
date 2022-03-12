package com.example.towerdefense;

import android.widget.ImageButton;

public class Cannon3 extends Tower {
    public Player player;
    public Cannon3(Player player, ImageButton button) {
        this.player = player;
        this.button = button;
        int cost = 100;
        double upgradeMultiplier = 1;

        if(player.difficulty.equals("medium")) {
            cost = 125;
            upgradeMultiplier = 1.2;
        }
        else if(player.difficulty.equals("hard")) {
            cost = 150;
            upgradeMultiplier = 1.5;
        }
        //might need to fix imageString
        //super(cost, 1, upgradeMultiplier, 10, 3, "", "../../../../res/drawable/cannon1new.jpg");
        this.cost = cost;
        this.upgradeMultiplier = upgradeMultiplier;
        this.attackSpeed = 3;
        this.attackDamage = 12;
        this.location = "";
        this.imageString = "../../../../res/drawable/cannon3new.jpg";
    }
}
