package com.game.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class EndScreen {
    private Scene endScene;
    private Stage stage;
    private double width;
    private double height;

    public EndScreen(Stage stage){
        this.stage = stage;
        this.width = Screen.getPrimary().getBounds().getWidth();
        this.height = Screen.getPrimary().getBounds().getHeight();
        endScene = new Scene(new StackPane(), width, height);
    }

    public Scene CreateEndScreen(){
        Text endText = new Text("Game Over! Thanks for playing.");
        Scene scene = new Scene(new StackPane(endText), width, height);
        stage.setScene(scene);
        return scene;
    }
}
