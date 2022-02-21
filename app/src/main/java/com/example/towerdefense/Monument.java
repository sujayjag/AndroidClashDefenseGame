package com.example.towerdefense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Monument {
    Intent intent = getIntent();


    private double health;
    private double money;
    private String difficulty = intent.getStringExtra("difficulty");
    //add any other attributes here. make sure to update constructors
    // and write getters/setters when you do that

    //default constructor
    public Monument() {

    }

    public Monument(double health, double money) {
        switch (difficulty) {
            case "Medium":
                health *= 0.9;
                money *= 0.9;
                break;
            case "Hard":
                health *= 0.75;
                money *= 0.75;
                break;
            default:
                break;
        }
        this.health = health;
        this.money = money;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
