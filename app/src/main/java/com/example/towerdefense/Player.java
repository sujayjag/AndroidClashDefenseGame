package com.example.towerdefense;

public class Player {
    public int balance;
    public String name;
    public String difficulty;

    Player(String difficulty, String name) {
        this.difficulty =  difficulty;
        this.name = name;
        if (difficulty.equals("easy")) {
            balance = 500;
        } else if (difficulty.equals("medium")) {
            balance = 750;
        } else if (difficulty.equals("hard")) {
            balance = 1000;
        }
    }

    public void updateBalance(int balance) {
        this.balance += balance;
    }


}
