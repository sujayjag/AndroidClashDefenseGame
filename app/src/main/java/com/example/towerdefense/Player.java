package com.example.towerdefense;

public class Player {
    private int balance;
    private String name;
    private String difficulty;
    private int monumentHealth;

    Player(String difficulty, String name) {
        this.setDifficulty(difficulty);
        this.setName(name);
        if (difficulty.equals("easy")) {
            setBalance(500);
            setMonumentHealth(100);
        } else if (difficulty.equals("medium")) {
            setBalance(750);
            setMonumentHealth(90);
        } else if (difficulty.equals("hard")) {
            setBalance(1000);
            setMonumentHealth(80);
        }
    }

    public void updateBalance(int balance) {
        this.setBalance(this.getBalance() + balance);
    }

    public void addBalance(Enemy enemy) {
        balance += enemy.getValue();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getMonumentHealth() {
        return monumentHealth;
    }

    public void setMonumentHealth(int monumentHealth) {
        this.monumentHealth = monumentHealth;
    }
}
