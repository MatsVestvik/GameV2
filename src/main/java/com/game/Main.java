package com.game;

import java.util.Stack;

import javax.swing.text.View;

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

        ViewCharacter yourPlayerView = new ViewCharacter(true, avatar, hero);

        CreateEnemies enemyCreator = new CreateEnemies();

        FightView fightView = new FightView(yourPlayerView, enemyCreator.getEnemyView(0), enemyCreator.getEnemyView(1), enemyCreator.getEnemyView(2));
        StackPane fightPane = fightView.getFightPane();



        stage.setScene(new javafx.scene.Scene(fightPane, 400, 400));
        stage.setTitle("Game Fight Simulation");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
        

    }
}