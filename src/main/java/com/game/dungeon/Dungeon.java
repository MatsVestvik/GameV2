package com.game.dungeon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;

public class Dungeon {

    private HBox box;

    public Dungeon(Stage stage) {
        box = new HBox();
        Character ch = new Character();
        Background bg = new Background();
        box.getChildren().add(ch.getCharacterImageView());
        box.getChildren().add(bg.getBackgroundImageView());
        box.setMaxWidth(Screen.getPrimary().getBounds().getWidth());
    }

    public HBox getBox() {return box;}
}