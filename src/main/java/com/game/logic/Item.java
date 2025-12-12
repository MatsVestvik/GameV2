package com.game.logic;

import javafx.scene.image.Image;

public class Item {

    private String name;
    private int armor;
    private int damage;
    private String type;
    private Image icon;

    public Item(String name, int armor, int damage, String type, Image icon) {
        this.name = name;
        this.armor = armor;
        this.damage = damage;
        setType(type);
        this.icon = icon;
    }

    public String getName() {return name;}
    public String getType() {return type;}
    public int getArmor() {return armor;}
    public int getDamage() {return damage;}
    public Image getIcon() {return icon;}

    public void setName(String name) {this.name = name;}
    public void setArmor(int armor) {this.armor = armor;}
    public void setDamage(int damage) {this.damage = damage;}

    public void setType(String type) {
        String[] validTypes = {"HELMET", "CHESTPLATE", "LEGGINGS", "BOOTS", "WEAPON", "OFFHAND"};
        for (String validType : validTypes) {
            if (validType.equals(type)) {
                this.type = type;
                return;
            }
        }
    }
    
}
