package com.game.logic;

public class Character {
    
    private String name;
    private int health;
    private int strength;
    private Item helmet;
    private Item chestplate;
    private Item leggings;
    private Item boots;
    private Item weapon;
    private Item offhand;

    public Character(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.helmet = null;
        this.chestplate = null;
        this.leggings = null;
        this.boots = null;
        this.weapon = null;
        this.offhand = null;
    }

    public int getHealth() {return health;}
    public int getStrength() {return strength;}
    public String getName() {return name;}

    public void setHealth(int health) {this.health = health;}
    
    public int getTotalArmor() {
        int totalArmor = 0;
        if (helmet != null) totalArmor += helmet.getArmor();
        if (chestplate != null) totalArmor += chestplate.getArmor();
        if (leggings != null) totalArmor += leggings.getArmor();
        if (boots != null) totalArmor += boots.getArmor();
        return totalArmor;
    }

    public int getTotalDamage() {
        int totalDamage = strength;
        if (weapon != null) totalDamage += weapon.getDamage();
        if (offhand != null) totalDamage += offhand.getDamage();
        return totalDamage;
    }
}