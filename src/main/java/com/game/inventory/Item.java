package com.game.inventory;

import javafx.scene.image.Image;

public class Item {
    private int armor = 0;
    private int damage = 0;
    private int rarity = 0;
    private Image itemImage;

    public Item(int rarity, int armor, int damage, String imgPath) {
        this.rarity = rarity;
        this.armor = armor;
        this.damage = damage;
        this.itemImage = new Image(imgPath);
    }

    public int getArmor() {return armor;}
    public int getDamage() {return damage;}
    public int getRarity() {return rarity;}
    public Image getItemImage() {return itemImage;}
}
