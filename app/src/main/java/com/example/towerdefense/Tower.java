package com.example.towerdefense;

public abstract class Tower {
    public int cost;
    public int level;
    public int upgradeMultiplier;
    public int attackSpeed;
    public int attackDamage;
    public String location;
    public String imageString;

    abstract public void update();
}
