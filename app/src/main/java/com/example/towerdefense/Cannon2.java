package com.example.towerdefense;

import android.widget.ImageButton;

public class Cannon2 extends Tower {


    public Cannon2(Player player, ImageButton button) {
        this.setPlayer(player);
        this.setButton(button);
        int cost = 75;
        double upgradeMultiplier = 1.2;

        if (player.getDifficulty().equals("medium")) {
            cost = 100;
            upgradeMultiplier = 1.4;
        } else if (player.getDifficulty().equals("hard")) {
            cost = 125;
            upgradeMultiplier = 1.5;
        }
        //might need to fix imageString
        //super(cost, 1, upgradeMultiplier, 10, 3, "", "../../../../res/drawable/cannon1new.jpg");
        int upgradeCost = (int) (cost * 0.60);
        this.setUpgradeCost(upgradeCost);
        this.setCost(cost);
        this.setUpgradeCost(upgradeCost);
        this.setUpgradeMultiplier(upgradeMultiplier);
        this.setAttackSpeed(2000);
        this.setAttackDamage(0.2f);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
