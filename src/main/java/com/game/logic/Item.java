package com.game.logic;

public class Item {

    private String name;
    private int armor;
    private int damage;

    public Item(String name, int armor, int damage) {
        this.name = name;
        this.armor = armor;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getArmor() {
        return armor;
    }

    public int getDamage() {
        return damage;
    }
    
}
