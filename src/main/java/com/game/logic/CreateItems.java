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
        Image helmetSprite = MakeImage.createImage("img/basic/armor/Basic_Helmet.png");
        Image helmetIcon = MakeImage.createImage("img/png/armour/Helmet_Icon.png");
        return new Item("Basic Item", 5*rarity, 0, "HELMET", helmetIcon, rarity, helmetSprite);
    }

    public Item makeChestplate(int rarity) {
        Image chestplateIcon = MakeImage.createImage("img/png/armour/ChestPlate_Icon.png");
        Image chestplateSprite = MakeImage.createImage("img/basic/armor/Basic_Chestplate.png");
        return new Item("Basic Item", 8*rarity, 0, "CHESTPLATE", chestplateIcon, rarity, chestplateSprite);
    }

    public Item makeLeggings(int rarity) {
        Image leggingsIcon = MakeImage.createImage("img/png/armour/Pants_Icon.png");
        Image leggingsSprite = MakeImage.createImage("img/basic/armor/Basic_Pants.png");
        return new Item("Basic Item", 7*rarity, 0, "LEGGINGS", leggingsIcon, rarity, leggingsSprite);
    }

    public Item makeBoots(int rarity) {
        Image bootsIcon = MakeImage.createImage("img/png/armour/Boots_Icon.png");
        Image bootsSprite = MakeImage.createImage("img/basic/armor/Basic_Shoes.png");
        return new Item("Basic Item", 4*rarity, 0, "BOOTS", bootsIcon, rarity, bootsSprite);
    }

    public Item makeSword(int rarity) {
        Image swordIcon = MakeImage.createImage("img/png/armour/Sword_Icon.png");
        Image swordSprite = MakeImage.createImage("img/basic/weapon/Basic_Sword.png");
        return new Item("Basic Item", 0, 15*rarity, "WEAPON", swordIcon, rarity, swordSprite);
    }

    public Item makeShield(int rarity) {
        Image shieldIcon = MakeImage.createImage("img/png/armour/Shield_Icon.png");
        Image shieldSprite = MakeImage.createImage("img/basic/weapon/Basic_Shield.png");
        return new Item("Basic Item", 5*rarity, 0, "OFFHAND", shieldIcon, rarity, shieldSprite);
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
