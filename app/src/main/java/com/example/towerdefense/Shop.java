package com.example.towerdefense;

public class Shop {

    public static boolean buyTower(Tower tower, Player player) {
        return player.getBalance() >= tower.getCost();
    }

}
