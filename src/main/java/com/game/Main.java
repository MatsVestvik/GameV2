package com.game;

import com.game.dungeon.Dungeon;
import com.game.inventory.Equipped;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Dungeon dg = new Dungeon(stage);
        
        Scene scene = new Scene(dg.getBox(), 800, 600, Color.SKYBLUE);


        Equipped eq = new Equipped();
        eq.setOnClickedEquippedSlotListener((slotIndex, itemData) -> {
            System.out.println("Equipped Slot " + slotIndex + " clicked. Item Data: " + itemData);
        });

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}