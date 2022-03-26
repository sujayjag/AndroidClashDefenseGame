package com.example.towerdefense;

public abstract class Enemy {
    private int attackSpeed;
    private int movementSpeed;
    private int damage;
    private int health;
    private boolean hasReachedMonument;

    //create view for the enemy (image)

    public Enemy(int attackSpeed, int movementSpeed, int damage, int health,
                 boolean hasReachedMonument) {
        this.attackSpeed = attackSpeed;
        this.movementSpeed = movementSpeed;
        this.damage = damage;
        this.health = health;
        this.hasReachedMonument = hasReachedMonument;
    }

    public Enemy() {
        this(0, 0, 0, 0, false);
    }

    
    public abstract void attack();

    public void deployEnemy() {
        //Add enemy to screen and start moving
    }
}
