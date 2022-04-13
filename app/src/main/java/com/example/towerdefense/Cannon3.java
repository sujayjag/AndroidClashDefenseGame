package com.example.towerdefense;

import android.widget.ImageButton;

public class Cannon3 extends Tower {
    private Player player;

    public Cannon3(Player player, ImageButton button) {
        this.setPlayer(player);
        this.setButton(button);
        int cost = 100;
        double upgradeMultiplier = 1;

        if (player.getDifficulty().equals("medium")) {
            cost = 125;
            upgradeMultiplier = 1.2;
        } else if (player.getDifficulty().equals("hard")) {
            cost = 150;
            upgradeMultiplier = 1.5;
        }
        //might need to fix imageString
        //super(cost, 1, upgradeMultiplier, 10, 3, "", "../../../../res/drawable/cannon1new.jpg");
        this.setCost(cost);
        this.setUpgradeMultiplier(upgradeMultiplier);
        this.setAttackSpeed(1000);
        this.setAttackDamage(0.3f);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
