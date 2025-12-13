package com.game;

import java.util.Stack;

import javax.swing.text.View;

import com.game.createView.FightView;
import com.game.createView.ViewCharacter;
import com.game.logic.Character;
import com.game.logic.Fight;
import com.game.logic.Item;
import com.game.logic.MakeImage;
import com.game.scenes.StartScreen;
import com.game.scenes.FightScreen;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

public class Main extends Application{

    @Override
    public void start(javafx.stage.Stage stage) {

        FightScreen fightScreen = new FightScreen();
        Scene fightScene = fightScreen.createFightScene(stage);
        
        StartScreen startScreen = new StartScreen(stage);
        Scene startScene = startScreen.CreateStartScreen(fightScene);

        stage.setScene(startScene);
        stage.setFullScreen(true);
        stage.setTitle("Game Fight Simulation");

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
        

    }
}