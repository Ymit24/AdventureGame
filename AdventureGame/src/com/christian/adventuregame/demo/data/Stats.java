package com.christian.adventuregame.demo.data;

import com.christian.adventuregame.demo.data.archetypes.Archetypes;

// TODO: Make this serializeable using ISerializable
public class Stats {
    public int health;
    public int maxHealth;

    public int level;
    public int xp;
    public int xpNext;

    public float moveSpeed;

    public Stats() {
        health = 100;
        maxHealth = 100;
        level = 0;
        xp = 0;
        xpNext = 10;
        moveSpeed = 6;
    }

    public void GainXp(int xp) {
        this.xp += xp;

        while (this.xp >= xpNext) {
            levelUp();
        }
    }

    private void levelUp() {
        xp -= xpNext;
        xpNext += 10; // TODO: Make this scale non-linear
        moveSpeed += 1.0f;
        level++;
        maxHealth += 45;
        health = maxHealth;

//        if (level == 2) {
//            State.world.player.inventory.storageItems[0] = Archetypes.Items.Get("yellow_staff_item");
//        }
    }
}
