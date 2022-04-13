package com.example.towerdefense;

import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Tower {
    private int cost;
    private int level;
    private double upgradeMultiplier;
    private int attackSpeed;
    private int attackDamage;

    private ImageButton button;

    public Tower(int cost, int level, double upgradeMultiplier, int attackSpeed,
                 int attackDamage, String location, String imageString) {
        this.setCost(cost);
        this.setLevel(level);
        this.setUpgradeMultiplier(upgradeMultiplier);
        this.setAttackSpeed(attackSpeed);
        this.setAttackDamage(attackDamage);
    }

    public Tower() {
        this(100, 1, 1, 20, 1, "", "");
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getUpgradeMultiplier() {
        return upgradeMultiplier;
    }

    public void setUpgradeMultiplier(double upgradeMultiplier) {
        this.upgradeMultiplier = upgradeMultiplier;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }


    public ImageButton getButton() {
        return button;
    }

    public void setButton(ImageButton button) {
        this.button = button;
    }

    //abstract public void upgrade();
}
