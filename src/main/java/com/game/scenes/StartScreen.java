package com.game.scenes;

import java.util.Stack;

import com.game.logic.MakeImage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;

public class StartScreen{

    private Scene startScene;
    private Stage stage;
    private double width;
    private double height;

    public StartScreen(Stage stage){
        this.stage = stage;
        this.width = stage.getWidth();
        startScene = new Scene(new StackPane(), width, stage.getHeight());
        this.height = stage.getHeight();
    }

    public Scene CreateStartScreen(Scene fightPane){
        Image backgroundImage = MakeImage.createImage("img/elements/Image.jpeg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(width);
        backgroundImageView.setFitHeight(height);
        backgroundImageView.setPreserveRatio(false);

        Button startButton = new Button("Start Fight");
        startButton.setStyle("-fx-font-size: 20px; -fx-padding: 10px 30px;");
        
        // Position the button (optional: center it)
        StackPane.setAlignment(startButton, javafx.geometry.Pos.CENTER);
        
        // Create layout
        StackPane root = new StackPane(backgroundImageView, startButton);
        Scene scene = new Scene(root, width, height);
        
        stage.setScene(scene);
       
        startButton.setOnAction(e -> {
            this.stage.setScene(fightPane); 
        });
        return scene;
    }
}
