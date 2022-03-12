package com.example.towerdefense;

import androidx.appcompat.app.AppCompatActivity;

public abstract class Tower extends AppCompatActivity {
    public int cost = 100;
    public int level = 1;
    public double upgradeMultiplier = 1;
    public int attackSpeed = 1;
    public int attackDamage = 20;
    public String location = "";
    public String imageString = "";

//    public Tower(int cost, int level, double upgradeMultiplier, int attackSpeed, int attackDamage, String location, String imageString) {
//        this.cost = cost;
//        this.level = level;
//        this.upgradeMultiplier = upgradeMultiplier;
//        this.attackSpeed = attackSpeed;
//        this.attackDamage = attackDamage;
//        this.location = location;
//        this.imageString = imageString;
//    }
//
//    public Tower(){
//        this(100, 1, 1, 20, 1, "", "");
//    }

    //abstract public void upgrade();
}
