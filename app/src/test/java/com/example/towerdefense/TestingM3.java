package com.example.towerdefense;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import android.widget.TextView;

public class TestingM3 {

    Player easyPlayer = new Player("easy", "easy player");
    Player mediumPlayer = new Player("medium", "medium player");
    Player hardPlayer = new Player("hard", "hard player");

    @Test
    public void diffInitialBalance() {
        assertTrue(easyPlayer.balance != mediumPlayer.balance &&
                mediumPlayer.balance != hardPlayer.balance &&
                easyPlayer.balance != hardPlayer.balance);
    }

    @Test
    public void diffDifficulty() {
        assertTrue(easyPlayer.difficulty != mediumPlayer.difficulty &&
                mediumPlayer.difficulty != hardPlayer.difficulty &&
                easyPlayer.difficulty != hardPlayer.difficulty);
    }

    // placable
    // balance updates
}
