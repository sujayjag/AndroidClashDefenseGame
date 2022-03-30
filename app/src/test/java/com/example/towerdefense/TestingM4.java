package com.example.towerdefense;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class TestingM4 {

    private Player easyPlayer = new Player("easy", "easy player");
    private Player dummyEasyPlayer = new Player("easy", "dummy easy player");
    private Player mediumPlayer = new Player("medium", "medium player");
    private Player dummyMediumPlayer = new Player("medium", "dummy medium player");
    private Player hardPlayer = new Player("hard", "hard player");
    private Player dummyHardPlayer = new Player("hard", "dummy hard player");
    private Enemy witch = new Enemy("witch");
    private Enemy wizard = new Enemy("wizard");
    private Enemy archer = new Enemy("archer");

    @Test
    public void diffEnemyDamage() {
        assertTrue(witch.getDamage() != wizard.getDamage()
            && witch.getDamage() != archer.getDamage()
            && wizard.getDamage() != archer.getDamage());
    }

    @Test
    public void diffEnemyMovementSpeed() {
        assertTrue(witch.getMovementSpeed() != wizard.getMovementSpeed()
            && witch.getMovementSpeed() != archer.getMovementSpeed()
            && wizard.getMovementSpeed() != archer.getMovementSpeed());
    }

    @Test
    public void diffTimeBetween() {
        assertTrue(witch.getTimeBetween() != wizard.getTimeBetween()
            && witch.getTimeBetween() != archer.getTimeBetween()
            && wizard.getTimeBetween() != archer.getTimeBetween());
    }

    @Test
    public void diffEnemyHealth() {
        assertTrue(witch.getHealth() != wizard.getHealth()
            && witch.getHealth() != archer.getHealth()
            && wizard.getHealth() != archer.getHealth());
    }

    @Test
    public void witchAttack() {
        witch.attack(easyPlayer);
        witch.attack(mediumPlayer);
        witch.attack(hardPlayer);
        assertTrue((easyPlayer.getMonumentHealth() ==
            (dummyEasyPlayer.getMonumentHealth() - witch.getDamage()))
            && (mediumPlayer.getMonumentHealth() ==
            (dummyMediumPlayer.getMonumentHealth() - witch.getDamage()))
            && (hardPlayer.getMonumentHealth() ==
            (dummyHardPlayer.getMonumentHealth() - witch.getDamage())));
    }

    @Test
    public void wizardAttack() {
        wizard.attack(easyPlayer);
        wizard.attack(mediumPlayer);
        wizard.attack(hardPlayer);
        assertTrue((easyPlayer.getMonumentHealth() ==
            (dummyEasyPlayer.getMonumentHealth() - wizard.getDamage()))
            && (mediumPlayer.getMonumentHealth() ==
            (dummyMediumPlayer.getMonumentHealth() - wizard.getDamage()))
            && (hardPlayer.getMonumentHealth() ==
            (dummyHardPlayer.getMonumentHealth() - wizard.getDamage())));
    }

    @Test
    public void archerAttack() {
        archer.attack(easyPlayer);
        archer.attack(mediumPlayer);
        archer.attack(hardPlayer);
        assertTrue((easyPlayer.getMonumentHealth() ==
            (dummyEasyPlayer.getMonumentHealth() - archer.getDamage()))
            && (mediumPlayer.getMonumentHealth() ==
            (dummyMediumPlayer.getMonumentHealth() - archer.getDamage()))
            && (hardPlayer.getMonumentHealth() ==
            (dummyHardPlayer.getMonumentHealth() - archer.getDamage())));
    }

    @Test
    public void testGameOver() {
        easyPlayer.setMonumentHealth(0);
    }


}
