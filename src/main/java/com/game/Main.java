package com.game;

import javax.swing.text.View;

import com.game.createView.FightScene;
import com.game.createView.FightView;
import com.game.createView.ViewCharacter;
import com.game.logic.Character;
import com.game.logic.Fight;
import com.game.logic.Item;
import com.game.logic.MakeImage;
import com.game.createView.FightView;

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
        Item sword = new Item("Sword", 0, 10, "WEAPON", swordIcon, 4);
        Image shieldIcon = MakeImage.createImage("img/basic/weapon/Basic_Shield.gif");
        Item shield = new Item("Shield", 20, 0, "OFFHAND", shieldIcon, 3);
        Image unitBackground = MakeImage.createImage("img/elements/UnitBackground.gif");

        hero.equipItem(sword);
        hero.equipItem(shield);
        
        Image villainAvatar = MakeImage.createImage("img/ninja/Ninja_Character.gif");
        Character villain = new Character("Villain", 100, 50, villainAvatar);

        ViewCharacter yourPlayerView = new ViewCharacter(true, avatar);
        yourPlayerView.addItemImageToPane(sword.getIcon(), sword.getRarity());
        yourPlayerView.addItemImageToPane(shield.getIcon(), shield.getRarity());

        Button start = new Button("Start Fight");
        start.setMinHeight(200);
        start.setMinWidth(200);
        start.setOpacity(0);
        yourPlayerView.getCharPane().getChildren().add(start);

        ViewCharacter enemyView = new ViewCharacter(false, villainAvatar);
        enemyView.addItemImageToPane(sword.getIcon(), sword.getRarity());
        enemyView.addItemImageToPane(shield.getIcon(), shield.getRarity());

        HBox fightHBox = new HBox();

        fightHBox.getChildren().addAll(yourPlayerView.getCharPane(), enemyView.getCharPane());

        start.setOnAction(e -> {
            FightView fightView = new FightView();
            fightView.attackAnimation(yourPlayerView);
            fightView.hurtAnimation(enemyView);
        });

        stage.setScene(new javafx.scene.Scene(fightHBox, 400, 400));
        stage.setTitle("Game Fight Simulation");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
        

    }
}