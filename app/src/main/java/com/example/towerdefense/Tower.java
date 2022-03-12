package com.example.towerdefense;

public abstract class Tower {
    public int cost;
    public int level;
    public double upgradeMultiplier;
    public int attackSpeed;
    public int attackDamage;
    public String location;
    public String imageString;

    public Tower(int cost, int level, double upgradeMultiplier, int attackSpeed, int attackDamage, String location, String imageString) {
        this.cost = cost;
        this.level = level;
        this.upgradeMultiplier = upgradeMultiplier;
        this.attackSpeed = attackSpeed;
        this.attackDamage = attackDamage;
        this.location = location;
        this.imageString = imageString;
    }

    public Tower(){
        this(100, 1, 1, 20, 1, "", "");
    }

    //abstract public void upgrade();
}
