package com.example.towerdefense;

public class Shop {

    public static boolean buyTower(Tower tower, Player player) {
        if (player.balance >= tower.cost) {
            player.balance -= tower.cost;
            return true;
        } else {
            return false;
        }
    }

}
