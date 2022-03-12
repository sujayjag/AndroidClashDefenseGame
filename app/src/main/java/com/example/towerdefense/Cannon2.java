package com.example.towerdefense;

import android.media.Image;
import android.widget.ImageButton;

public class Cannon2 extends Tower {
    public Player player;
    public Cannon2(Player player, ImageButton button) {
        this.player = player;
        this.button = button;
        int cost = 75;
        double upgradeMultiplier = 1;

        if(player.difficulty.equals("medium")) {
            cost = 100;
            upgradeMultiplier = 1.2;
        }
        else if(player.difficulty.equals("hard")) {
            cost = 125;
            upgradeMultiplier = 1.5;
        }
        //might need to fix imageString
        //super(cost, 1, upgradeMultiplier, 10, 3, "", "../../../../res/drawable/cannon1new.jpg");
        this.cost = cost;
        this.upgradeMultiplier = upgradeMultiplier;
        this.attackSpeed = 7;
        this.attackDamage = 5;
        this.location = "";
        this.imageString = "../../../../res/drawable/Cannon2new.jpg";
    }
}
