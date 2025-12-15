package com.game;

import javax.swing.text.View;

import com.game.createView.ViewCharacter;
import com.game.createView.inventory.EquippedGrid;
import com.game.createView.inventory.InventoryGrid;
import com.game.logic.MakeImage;
import javafx.scene.image.Image;
import com.game.logic.Character;
import com.game.logic.CreateItems;
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
        createAllItems();
        return heroView;
    }

    public Character getHero() {return hero;}  
    public ViewCharacter getHeroView() {return heroView;}

    private void equipItemToCharacter(Item item) {
        equippedGrid.addItemToSlot(item);
        heroView.addItemImageToPane(item.getSprite(), item.getRarity(), item.getType());
        hero.equipItem(item);
    }

    private void createAllItems() {
        Item baseHelmet = new Item("Basic Item", 5, 0, "HELMET", MakeImage.createImage("img/png/armour/Helmet_Icon.png"), 1, MakeImage.createImage("img/basic/armor/Basic_Helmet.png"));
        createAllRarities(baseHelmet);
        Item baseChestplate = new Item("Basic Item", 8, 0, "CHESTPLATE", MakeImage.createImage("img/png/armour/ChestPlate_Icon.png"), 1, MakeImage.createImage("img/basic/armor/Basic_Chestplate.png"));
        createAllRarities(baseChestplate);
        Item baseLeggings = new Item("Basic Item", 7, 0, "LEGGINGS", MakeImage.createImage("img/png/armour/Pants_Icon.png"), 1, MakeImage.createImage("img/basic/armor/Basic_Pants.png"));
        createAllRarities(baseLeggings);
        Item baseBoots = new Item("Basic Item", 4, 0, "BOOTS", MakeImage.createImage("img/png/armour/Boots_Icon.png"), 1, MakeImage.createImage("img/basic/armor/Basic_Shoes.png"));
        createAllRarities(baseBoots);
        Item baseSword = new Item("Basic Item", 0, 15, "WEAPON", MakeImage.createImage("img/png/armour/Sword_Icon.png"), 1, MakeImage.createImage("img/basic/weapon/Basic_Sword.png"));
        createAllRarities(baseSword);
        Item baseShield = new Item("Basic Item", 5, 0, "OFFHAND", MakeImage.createImage("img/png/armour/Shield_Icon.png"), 1, MakeImage.createImage("img/basic/weapon/Basic_Shield.png"));
        createAllRarities(baseShield);
    }

    private void createAllRarities(Item item) {
        for (int rarity = 1; rarity <= 4; rarity++) {
            Item newItem = new Item(item.getName(), item.getArmor()*rarity, item.getDamage()*rarity, item.getType(), item.getIcon(), rarity, item.getSprite());
            inventoryGrid.addItemToFirstAvailable(newItem);
        }
    }
}
