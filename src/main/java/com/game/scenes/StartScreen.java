package com.game.scenes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class StartScreen{

    private Scene startScene;
    private Stage stage;
    private double width;

    public StartScreen(Stage stage){
        this.stage = stage;
        this.width = stage.getWidth();
        startScene = new Scene(new javafx.scene.layout.StackPane(), width, stage.getHeight());
    }

    public Scene CreateStartScreen(Scene fightPane){
        Button startButton = new Button("Start Fight");
        Scene scene = new Scene(new StackPane(startButton), width, stage.getHeight());
        stage.setScene(scene);
       
        startButton.setOnAction(e -> {
            this.stage.setScene(fightPane); 
        });
        return scene;
    }
}
