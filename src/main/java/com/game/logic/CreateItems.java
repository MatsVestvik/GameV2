package com.game.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.image.Image;

public class CreateItems {
    private List<Item> items;

    public CreateItems() {
        items = new ArrayList<>();
        createRandomEquipmentSet();
    }

    public List<Item> getItems() {return items;}

    public Item makeHelmet(int rarity) {
        Image helmetSprite = MakeImage.createImage("img/basic/armor/Basic_Helmet_2.gif");
        Image helmetIcon = MakeImage.createImage("img/png/armour/Helmet_Icon.png");
        return new Item("Basic Item", 5*rarity, 0, "HELMET", helmetIcon, rarity, helmetSprite);
    }

    public Item makeChestplate(int rarity) {
        Image chestplateSprite = MakeImage.createImage("img/basic/armor/Basic_Chestplate.gif");
        return new Item("Basic Item", 8*rarity, 0, "CHESTPLATE", chestplateSprite, rarity, chestplateSprite);
    }

    public Item makeLeggings(int rarity) {
        Image leggingsSprite = MakeImage.createImage("img/basic/armor/Basic_pants.gif");
        return new Item("Basic Item", 7*rarity, 0, "LEGGINGS", leggingsSprite, rarity, leggingsSprite);
    }

    public Item makeBoots(int rarity) {
        Image bootsSprite = MakeImage.createImage("img/basic/armor/Basic_Shoes.gif");
        return new Item("Basic Item", 4*rarity, 0, "BOOTS", bootsSprite, rarity, bootsSprite);
    }

    public Item makeSword(int rarity) {
        Image swordSprite = MakeImage.createImage("img/basic/weapon/Basic_Sword.gif");
        return new Item("Basic Item", 0, 15*rarity, "WEAPON", swordSprite, rarity, swordSprite);
    }

    public Item makeShield(int rarity) {
        Image shieldSprite = MakeImage.createImage("img/basic/weapon/Basic_Shield.gif");
        return new Item("Basic Item", 5*rarity, 0, "OFFHAND", shieldSprite, rarity, shieldSprite);
    }

    public void createEquipmentSet(int rarity) {
        items.add(makeHelmet(rarity));
        items.add(makeChestplate(rarity));
        items.add(makeLeggings(rarity));
        items.add(makeBoots(rarity));
        items.add(makeSword(rarity));
        items.add(makeShield(rarity));
    }

    public void createRandomEquipmentSet() {
        Random rand = new Random();
        items.add(makeHelmet(rand.nextInt(5) ));
        items.add(makeChestplate(rand.nextInt(5) )); 
        items.add(makeLeggings(rand.nextInt(5) ));   
        items.add(makeBoots(rand.nextInt(5) ));
        items.add(makeSword(rand.nextInt(5) ));
        items.add(makeShield(rand.nextInt(5) ));

    }
}
