package com.game.dungeon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Background {
    private Image backgroundImage;
    private ImageView backgroundImageView;

    public Background() {
        this.backgroundImage = new Image("img/elements/Dungeon.png");
        this.backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(Screen.getPrimary().getBounds().getWidth()*3/4);
        backgroundImageView.setFitHeight(Screen.getPrimary().getBounds().getWidth() / 4);
    }

    public Image getBackgroundImage() {return backgroundImage;}
    public ImageView getBackgroundImageView() {return backgroundImageView;}
}