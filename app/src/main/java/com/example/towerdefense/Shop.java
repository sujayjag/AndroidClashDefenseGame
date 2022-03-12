package com.example.towerdefense;

public class Shop {
    public boolean buyTower(Tower tower, Player player) {
        if (player.balance >= tower.cost) {
            player.updateBalance(-1*tower.cost);
            return true;
        } else {
            return false;
        }
    }
}
