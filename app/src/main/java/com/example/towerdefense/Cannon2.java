package com.example.towerdefense;

import android.widget.ImageButton;

public class Cannon2 extends Tower {
    private Player player;

    public Cannon2(Player player, ImageButton button) {
        this.setPlayer(player);
        this.setButton(button);
        int cost = 75;
        double upgradeMultiplier = 1;

        if (player.getDifficulty().equals("medium")) {
            cost = 100;
            upgradeMultiplier = 1.2;
        } else if (player.getDifficulty().equals("hard")) {
            cost = 125;
            upgradeMultiplier = 1.5;
        }
        //might need to fix imageString
        //super(cost, 1, upgradeMultiplier, 10, 3, "", "../../../../res/drawable/cannon1new.jpg");
        this.setCost(cost);
        this.setUpgradeMultiplier(upgradeMultiplier);
        this.setAttackSpeed(7);
        this.setAttackDamage(5);
        this.setLocation("");
        this.setImageString("../../../../res/drawable/cannon2new.jpg");
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
