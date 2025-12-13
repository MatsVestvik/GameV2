package com.game.createView;

import com.game.logic.MakeImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;

public class BackgroundView {

    private HBox backgroundHBox;
    private double width = Screen.getPrimary().getBounds().getWidth() / 4;
    
    public BackgroundView(int numberOfCharacters) {
        Image unitBackground = MakeImage.createImage("img/elements/UnitBackground.gif");
        backgroundHBox = new HBox();
        for (int i = 0; i < numberOfCharacters; i++) {
            ImageView unitBackgroundView = new ImageView(unitBackground);
            unitBackgroundView.setFitWidth(width);
            unitBackgroundView.setPreserveRatio(true);
            backgroundHBox.getChildren().add(unitBackgroundView);
        }
    }

    public HBox getBackgroundHBox() {return backgroundHBox;}

    
}
