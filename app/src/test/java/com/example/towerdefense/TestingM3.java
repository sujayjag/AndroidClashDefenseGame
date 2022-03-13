package com.example.towerdefense;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class TestingM3 {

    Player easyPlayer = new Player("easy", "easy player");
    Player mediumPlayer = new Player("medium", "medium player");
    Player hardPlayer = new Player("hard", "hard player");

    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;

    Cannon1 easyCannon1 = new Cannon1(easyPlayer, imageButton1);
    Cannon1 mediumCannon1 = new Cannon1(mediumPlayer, imageButton1);
    Cannon1 hardCannon1 = new Cannon1(hardPlayer, imageButton1);

    Cannon2 easyCannon2 = new Cannon2(easyPlayer, imageButton2);
    Cannon2 mediumCannon2 = new Cannon2(mediumPlayer, imageButton2);
    Cannon2 hardCannon2 = new Cannon2(hardPlayer, imageButton2);

    Cannon3 easyCannon3 = new Cannon3(easyPlayer, imageButton3);
    Cannon3 mediumCannon3 = new Cannon3(mediumPlayer, imageButton3);
    Cannon3 hardCannon3 = new Cannon3(hardPlayer, imageButton3);

    @Test
    public void diffInitialBalance() {
        assertTrue(easyPlayer.getBalance() != mediumPlayer.getBalance() &&
                mediumPlayer.getBalance() != hardPlayer.getBalance() &&
                easyPlayer.getBalance() != hardPlayer.getBalance());
    }

    @Test
    public void diffMonumentHealth() {
        assertTrue(easyPlayer.getMonumentHealth() != mediumPlayer.getMonumentHealth() &&
                mediumPlayer.getMonumentHealth() != hardPlayer.getMonumentHealth() &&
                easyPlayer.getMonumentHealth() != hardPlayer.getMonumentHealth());
    }

    @Test
    public void diffDifficulty() {
        assertTrue(easyPlayer.getDifficulty() != mediumPlayer.getDifficulty() &&
                mediumPlayer.getDifficulty() != hardPlayer.getDifficulty() &&
                easyPlayer.getDifficulty() != hardPlayer.getDifficulty());
    }

    @Test
    public void diffCannon1InitialCosts() {
        assertTrue(easyCannon1.getCost() != mediumCannon1.getCost() &&
                easyCannon1.getCost() != hardCannon1.getCost() &&
                mediumCannon1.getCost() != hardCannon1.getCost());
    }

    @Test
    public void diffCannon2InitialCosts() {
        assertTrue(easyCannon2.getCost() != mediumCannon2.getCost() &&
                easyCannon2.getCost() != hardCannon2.getCost() &&
                mediumCannon2.getCost() != hardCannon2.getCost());
    }

    @Test
    public void diffCannon3InitialCosts() {
        assertTrue(easyCannon3.getCost() != mediumCannon3.getCost() &&
                easyCannon3.getCost() != hardCannon3.getCost() &&
                mediumCannon3.getCost() != hardCannon3.getCost());
    }

    @Test
    public void testBuyTower() {
        boolean greater = Shop.buyTower(easyCannon1, easyPlayer);
        easyPlayer.updateBalance(-1 * 450);
        boolean equals = Shop.buyTower(easyCannon1, easyPlayer);
        easyPlayer.updateBalance(-1 * 10);
        boolean less = Shop.buyTower(easyCannon1, easyPlayer);
        assertTrue(greater == equals && greater != less && equals != less);
    }

    @Test
    public void diffCannonsUpgradeMultipliers() {
        assertTrue(easyCannon1.getUpgradeMultiplier() != mediumCannon1.getUpgradeMultiplier() &&
                easyCannon1.getUpgradeMultiplier() != hardCannon1.getUpgradeMultiplier() &&
                mediumCannon1.getUpgradeMultiplier() != hardCannon1.getUpgradeMultiplier() &&
                easyCannon2.getUpgradeMultiplier() != mediumCannon2.getUpgradeMultiplier() &&
                easyCannon2.getUpgradeMultiplier() != hardCannon2.getUpgradeMultiplier() &&
                mediumCannon2.getUpgradeMultiplier() != hardCannon2.getUpgradeMultiplier() &&
                easyCannon3.getUpgradeMultiplier() != mediumCannon3.getUpgradeMultiplier() &&
                easyCannon3.getUpgradeMultiplier() != hardCannon3.getUpgradeMultiplier() &&
                mediumCannon3.getUpgradeMultiplier() != hardCannon3.getUpgradeMultiplier());
    }

    @Test
    public void diffCannonsAttackSpeeds() {
        assertTrue(easyCannon1.getAttackSpeed() != easyCannon2.getAttackSpeed() &&
                easyCannon1.getAttackSpeed() != easyCannon3.getAttackSpeed() &&
                easyCannon2.getAttackSpeed() != easyCannon3.getAttackSpeed() &&
                mediumCannon1.getAttackSpeed() != mediumCannon2.getAttackSpeed() &&
                mediumCannon1.getAttackSpeed() != mediumCannon3.getAttackSpeed() &&
                mediumCannon2.getAttackSpeed() != mediumCannon3.getAttackSpeed() &&
                hardCannon1.getAttackSpeed() != hardCannon2.getAttackSpeed() &&
                hardCannon1.getAttackSpeed() != hardCannon3.getAttackSpeed() &&
                hardCannon2.getAttackSpeed() != hardCannon3.getAttackSpeed());
    }

    @Test
    public void diffCannonsAttackDamage() {
        assertTrue(easyCannon1.getAttackDamage() != easyCannon2.getAttackDamage() &&
                easyCannon1.getAttackDamage() != easyCannon3.getAttackDamage() &&
                easyCannon2.getAttackDamage() != easyCannon3.getAttackDamage() &&
                mediumCannon1.getAttackDamage() != mediumCannon2.getAttackDamage() &&
                mediumCannon1.getAttackDamage() != mediumCannon3.getAttackDamage() &&
                mediumCannon2.getAttackDamage() != mediumCannon3.getAttackDamage() &&
                hardCannon1.getAttackDamage() != hardCannon2.getAttackDamage() &&
                hardCannon1.getAttackDamage() != hardCannon3.getAttackDamage() &&
                hardCannon2.getAttackDamage() != hardCannon3.getAttackDamage());
    }
}
