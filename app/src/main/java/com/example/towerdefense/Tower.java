package com.example.towerdefense;

import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Tower {
    private int cost;
    private int upgradeCost;
    private int level = 1;
    private double upgradeMultiplier;
    private double attackSpeed;
    private float attackDamage;
    private Timer timer = new Timer();
    private int millisecondsPassed;
    protected Player player;

    private ImageButton button;

    public Tower(int cost, int level, double upgradeMultiplier, int attackSpeed,
                 float attackDamage, String location, String imageString) {
        this.setCost(cost);
        this.setLevel(level);
        this.setUpgradeMultiplier(upgradeMultiplier);
        this.setAttackSpeed(attackSpeed);
        this.setAttackDamage(attackDamage);
    }

    public void upgrade() {
        if (Shop.upgradeTower(this, player)) {
            this.setAttackDamage( (float) GameScreen.round((float) ((this.getAttackDamage() * upgradeMultiplier))));
            this.setAttackSpeed(GameScreen.round((this.getAttackSpeed() / upgradeMultiplier)));
            level++;
            player.setBalance(player.getBalance() - this.getUpgradeCost());
        } else {
            throw new IllegalArgumentException();
        }

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

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public float getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(float attackDamage) {
        this.attackDamage = attackDamage;
    }


    public ImageButton getButton() {
        return button;
    }

    public void setButton(ImageButton button) {
        this.button = button;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void startTimer() {
        setMillisecondsPassed(0);
        TimerTask task = new TimerTask() {
            public void run() {
                setMillisecondsPassed(getMillisecondsPassed() + 1);
            }
        };
        timer.scheduleAtFixedRate(task, 1, 1);
    }

    public int getMillisecondsPassed() {
        return millisecondsPassed;
    }

    public void setMillisecondsPassed(int millisecondsPassed) {
        this.millisecondsPassed = millisecondsPassed;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(int upgradeCost) {
        this.upgradeCost = upgradeCost;
    }


    //abstract public void upgrade();
}
