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
        Item sword = new Item("Basic Item", 0, 15, "WEAPON", MakeImage.createImage("img/basic/weapon/Basic_Sword.gif"), 4);
        Item shield = new Item("Basic Item", 10, 0, "OFFHAND", MakeImage.createImage("img/basic/weapon/Basic_Shield.gif"), 4);
        Item helmet = new Item("Basic Item", 5, 5, "HELMET", MakeImage.createImage("img/basic/armor/Basic_Helmet_2.gif"), 4);
        Item chestplate = new Item("Basic Item", 10, 5, "CHESTPLATE", MakeImage.createImage("img/basic/armor/Basic_Chestplate.gif"), 4);
        Item leggings = new Item("Basic Item", 8, 5, "LEGGINGS", MakeImage.createImage("img/basic/armor/Basic_pants.gif"), 4);
        Item boots = new Item("Basic Item", 4, 5, "BOOTS", MakeImage.createImage("img/basic/armor/Basic_Shoes.gif"), 4);
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
