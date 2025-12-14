package com.game;

import javax.swing.text.View;

import com.game.createView.ViewCharacter;
import com.game.createView.inventory.EquippedGrid;
import com.game.createView.inventory.InventoryGrid;
import com.game.logic.MakeImage;
import javafx.scene.image.Image;
import com.game.logic.Character;
import com.game.logic.Item;

import javafx.scene.image.Image;

public class CreateHero {

    private Character hero;
    private ViewCharacter heroView;
    private InventoryGrid inventoryGrid;
    private EquippedGrid equippedGrid;

    public ViewCharacter CreateMainCharacter(InventoryGrid inventoryGrid, EquippedGrid equippedGrid) {
        this.inventoryGrid = inventoryGrid;
        this.equippedGrid = equippedGrid;
        Image avatar = MakeImage.createImage("img/basic/character/Basic_Character.gif");
        hero = new Character("Hero", 100, 50, avatar);
        heroView = new ViewCharacter(true, avatar, hero);
        int rarity = 4;
        Item sword = new Item("Basic Item", 0*rarity, 10*rarity, "WEAPON", MakeImage.createImage("img/basic/weapon/Basic_Sword.gif"), rarity);
        Item shield = new Item("Basic Item", 5*rarity, 0*rarity, "OFFHAND", MakeImage.createImage("img/basic/weapon/Basic_Shield.gif"), rarity);
        Item helmet = new Item("Basic Item", 5*rarity, 0*rarity, "HELMET", MakeImage.createImage("img/basic/armor/Basic_Helmet_2.gif"), rarity);
        Item chestplate = new Item("Basic Item", 8*rarity, 0*rarity, "CHESTPLATE", MakeImage.createImage("img/basic/armor/Basic_Chestplate.gif"), rarity);
        Item leggings = new Item("Basic Item", 7*rarity, 0*rarity, "LEGGINGS", MakeImage.createImage("img/basic/armor/Basic_pants.gif"), rarity);
        Item boots = new Item("Basic Item", 4*rarity, 0*rarity, "BOOTS", MakeImage.createImage("img/basic/armor/Basic_Shoes.gif"), rarity);
        equipItemToCharacter(sword);
        equipItemToCharacter(shield);
        equipItemToCharacter(helmet);
        equipItemToCharacter(chestplate);
        equipItemToCharacter(leggings);
        equipItemToCharacter(boots);
        createAllItems();
        return heroView;
    }

    public Character getHero() {return hero;}  
    public ViewCharacter getHeroView() {return heroView;}

    private void equipItemToCharacter(Item item) {
        equippedGrid.addItemToSlot(item);
        heroView.addItemImageToPane(item.getIcon(), item.getRarity(), item.getType());
        hero.equipItem(item);
    }

    private void createAllItems() {
        Item baseHelmet = new Item("Basic Item", 5, 0, "HELMET", MakeImage.createImage("img/basic/armor/Basic_Helmet_2.gif"), 1);
        createAllRarities(baseHelmet);
        Item baseChestplate = new Item("Basic Item", 8, 0, "CHESTPLATE", MakeImage.createImage("img/basic/armor/Basic_Chestplate.gif"), 1);
        createAllRarities(baseChestplate);
        Item baseLeggings = new Item("Basic Item", 7, 0, "LEGGINGS", MakeImage.createImage("img/basic/armor/Basic_pants.gif"), 1);
        createAllRarities(baseLeggings);
        Item baseBoots = new Item("Basic Item", 4, 0, "BOOTS", MakeImage.createImage("img/basic/armor/Basic_Shoes.gif"), 1);
        createAllRarities(baseBoots);
        Item baseSword = new Item("Basic Item", 0, 15, "WEAPON", MakeImage.createImage("img/basic/weapon/Basic_Sword.gif"), 1);
        createAllRarities(baseSword);
        Item baseShield = new Item("Basic Item", 5, 0, "OFFHAND", MakeImage.createImage("img/basic/weapon/Basic_Shield.gif"), 1);
        createAllRarities(baseShield);
    }

    private void createAllRarities(Item item) {
        for (int rarity = 1; rarity <= 5; rarity++) {
            Item newItem = new Item(item.getName(), item.getArmor()*rarity, item.getDamage()*rarity, item.getType(), item.getIcon(), rarity);
            inventoryGrid.addItemToFirstAvailable(newItem);
        }
    }
}
