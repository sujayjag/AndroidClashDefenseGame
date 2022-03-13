package com.example.towerdefense;

import android.widget.ImageButton;

public class Cannon1 extends Tower {
    private Player player;

    public Cannon1(Player player, ImageButton button) {
        this.setPlayer(player);
        this.setButton(button);
        int cost = 50;
        double upgradeMultiplier = 1;

        if (player.getDifficulty().equals("medium")) {
            cost = 75;
            upgradeMultiplier = 1.2;
        } else if (player.getDifficulty().equals("hard")) {
            cost = 100;
            upgradeMultiplier = 1.5;
        }
        //might need to fix imageString
        //super(cost, 1, upgradeMultiplier, 10, 3, "", "../../../../res/drawable/cannon1new.jpg");
        this.setCost(cost);
        this.setUpgradeMultiplier(upgradeMultiplier);
        this.setAttackSpeed(10);
        this.setAttackDamage(3);
        this.setLocation("");
        this.setImageString("../../../../res/drawable/cannon1new.jpg");
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
