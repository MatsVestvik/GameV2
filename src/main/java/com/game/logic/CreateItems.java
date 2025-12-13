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
        Image helmetImage = MakeImage.createImage("img/basic/armor/Basic_Helmet_2.gif");
        return new Item("Basic Item", 5*rarity, 0, "HELMET", helmetImage, rarity);
    }

    public Item makeChestplate(int rarity) {
        Image chestplateImage = MakeImage.createImage("img/basic/armor/Basic_Chestplate.gif");
        return new Item("Basic Item", 8*rarity, 0, "CHESTPLATE", chestplateImage, rarity);
    }

    public Item makeLeggings(int rarity) {
        Image leggingsImage = MakeImage.createImage("img/basic/armor/Basic_pants.gif");
        return new Item("Basic Item", 7*rarity, 0, "LEGGINGS", leggingsImage, rarity);
    }

    public Item makeBoots(int rarity) {
        Image bootsImage = MakeImage.createImage("img/basic/armor/Basic_Shoes.gif");
        return new Item("Basic Item", 4*rarity, 0, "BOOTS", bootsImage, rarity);
    }

    public Item makeSword(int rarity) {
        Image swordImage = MakeImage.createImage("img/basic/weapon/Basic_Sword.gif");
        return new Item("Basic Item", 0, 15*rarity, "WEAPON", swordImage, rarity);
    }

    public Item makeShield(int rarity) {
        Image shieldImage = MakeImage.createImage("img/basic/weapon/Basic_Shield.gif");
        return new Item("Basic Item", 5*rarity, 0, "OFFHAND", shieldImage, rarity);
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
