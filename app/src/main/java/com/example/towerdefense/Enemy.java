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
    //use Player.setMonumentHealth based on tower's damage
    //Update text
    //Check if momnument is below 0, if it is endGame()
    //Despawn the enemy object

    public void deployEnemy() {
        //Add enemy to screen and start moving
    }
}
