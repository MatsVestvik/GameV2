package com.game;

import com.game.logic.Character;
import com.game.logic.Fight;
import com.game.logic.Item;
import com.game.logic.MakeImage;

import javafx.application.Application;
import javafx.scene.image.Image;

public class Main extends Application{

    @Override
    public void start(javafx.stage.Stage stage) {

        Image avatar = MakeImage.createImage("img/basic/character/Basic_Character.gif");
        Character hero = new Character("Hero", 100, 15, avatar);

        Image swordIcon = MakeImage.createImage("img/basic/weapon/Basic_Sword.gif");
        Item sword = new Item("Sword", 0, 10, "WEAPON", swordIcon);
        Image shieldIcon = MakeImage.createImage("img/basic/weapon/Basic_Shield.gif");
        Item shield = new Item("Shield", 20, 0, "OFFHAND", shieldIcon);

        hero.equipItem(sword);
        hero.equipItem(shield);
        
        Image villainAvatar = MakeImage.createImage("img/ninja/Ninja_Character.gif");
        Character villain = new Character("Villain", 100, 50, villainAvatar);

        Group 

        Fight fight = new Fight();
        fight.fight(hero, villain);


        stage.setTitle("Game Fight Simulation");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
        

    }
}