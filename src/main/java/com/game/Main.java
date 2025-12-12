package com.game;

import com.game.createView.ViewCharacter;
import com.game.logic.Character;
import com.game.logic.Fight;
import com.game.logic.Item;
import com.game.logic.MakeImage;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

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

        ViewCharacter yourPlayerView = new ViewCharacter(true);
        yourPlayerView.addImageToPane(hero.getAvatar());
        yourPlayerView.addImageToPane(sword.getIcon());
        yourPlayerView.addImageToPane(shield.getIcon());

        Button start = new Button("Start Fight");
        yourPlayerView.getCharPane().getChildren().add(start);

        ViewCharacter enemyView = new ViewCharacter(false);
        enemyView.addImageToPane(villain.getAvatar());

        HBox fightHBox = new HBox();

        fightHBox.getChildren().addAll(yourPlayerView.getCharPane(), enemyView.getCharPane());

        start.setOnAction(e -> {
            Fight fight = new Fight();
            fight.fight(hero, villain);
        });

        stage.setScene(new javafx.scene.Scene(fightHBox, 400, 400));
        stage.setTitle("Game Fight Simulation");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
        

    }
}