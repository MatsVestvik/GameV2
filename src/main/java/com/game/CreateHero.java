package com.game;

import javax.swing.text.View;

import com.game.createView.ViewCharacter;
import com.game.logic.MakeImage;
import javafx.scene.image.Image;
import com.game.logic.Character;
import com.game.logic.Item;

import javafx.scene.image.Image;

public class CreateHero {
    public ViewCharacter CreateMainCharacter() {
        Image avatar = MakeImage.createImage("img/basic/character/Basic_Character.gif");
        Character hero = new Character("Hero", 100, 100, avatar);
        int rarity = 4;
        Item sword = new Item("Basic Item", 0*rarity, 15*rarity, "WEAPON", MakeImage.createImage("img/basic/weapon/Basic_Sword.gif"), rarity);
        Item shield = new Item("Basic Item", 5*rarity, 0*rarity, "OFFHAND", MakeImage.createImage("img/basic/weapon/Basic_Shield.gif"), rarity);
        Item helmet = new Item("Basic Item", 5*rarity, 0*rarity, "HELMET", MakeImage.createImage("img/basic/armor/Basic_Helmet_2.gif"), rarity);
        Item chestplate = new Item("Basic Item", 8*rarity, 0*rarity, "CHESTPLATE", MakeImage.createImage("img/basic/armor/Basic_Chestplate.gif"), rarity);
        Item leggings = new Item("Basic Item", 7*rarity, 0*rarity, "LEGGINGS", MakeImage.createImage("img/basic/armor/Basic_pants.gif"), rarity);
        Item boots = new Item("Basic Item", 4*rarity, 0*rarity, "BOOTS", MakeImage.createImage("img/basic/armor/Basic_Shoes.gif"), rarity);
        hero.equipItem(sword);
        hero.equipItem(shield);
        hero.equipItem(helmet);
        hero.equipItem(chestplate);
        hero.equipItem(leggings);
        hero.equipItem(boots);
        ViewCharacter yourPlayerView = new ViewCharacter(true, avatar, hero);
        yourPlayerView.addItemImageToPane(sword.getIcon(), sword.getRarity());
        yourPlayerView.addItemImageToPane(helmet.getIcon(), helmet.getRarity());
        yourPlayerView.addItemImageToPane(chestplate.getIcon(), chestplate.getRarity());
        yourPlayerView.addItemImageToPane(leggings.getIcon(), leggings.getRarity());
        yourPlayerView.addItemImageToPane(boots.getIcon(), boots.getRarity());
        yourPlayerView.addItemImageToPane(shield.getIcon(), shield.getRarity());
        return yourPlayerView;
    }
}
