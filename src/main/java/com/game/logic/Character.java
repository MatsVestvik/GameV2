package com.game.logic;

import javafx.scene.image.Image;

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
    private Image avatar;

    public Character(String name, int health, int strength, Image avatar) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.avatar = avatar;
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
    public Image getAvatar() {return avatar;}

    public void setHealth(int health) {this.health = health;}
    
    public int getTotalArmor() {
        int totalArmor = 0;
        if (helmet != null) totalArmor += helmet.getArmor();
        if (chestplate != null) totalArmor += chestplate.getArmor();
        if (leggings != null) totalArmor += leggings.getArmor();
        if (boots != null) totalArmor += boots.getArmor();
        if (weapon != null) totalArmor += weapon.getArmor();
        if (offhand != null) totalArmor += offhand.getArmor();
        return totalArmor;
    }

    public int getTotalDamage() {
        int totalDamage = strength;
        if (weapon != null) totalDamage += weapon.getDamage();
        if (offhand != null) totalDamage += offhand.getDamage();
        return totalDamage;
    }

    public void equipItem(Item item) {
        switch (item.getType()) {
            case "HELMET":
                this.helmet = item;
                break;
            case "CHESTPLATE":
                this.chestplate = item;
                break;
            case "LEGGINGS":
                this.leggings = item;
                break;
            case "BOOTS":
                this.boots = item;
                break;
            case "WEAPON":
                this.weapon = item;
                break;
            case "OFFHAND":
                this.offhand = item;
                break;
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}