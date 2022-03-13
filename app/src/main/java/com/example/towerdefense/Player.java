package com.example.towerdefense;

public class Player {
    public int balance;
    public String name;
    public String difficulty;
    public int monumentHealth;

    Player(String difficulty, String name) {
        this.difficulty =  difficulty;
        this.name = name;
        if (difficulty.equals("easy")) {
            balance = 500;
            monumentHealth = 100;
        } else if (difficulty.equals("medium")) {
            balance = 750;
            monumentHealth = 90;
        } else if (difficulty.equals("hard")) {
            balance = 1000;
            monumentHealth = 80;
        }
    }

    public void updateBalance(int balance) {
        this.balance += balance;
    }


}
