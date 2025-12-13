package com.game.createView;

import com.game.logic.MakeImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BackgroundView {
    
    public BackgroundView(int numberOfCharacters) {
        Image unitBackground = MakeImage.createImage("img/elements/UnitBackground.gif");
        HBox backgroundHBox = new HBox();
        for (int i = 0; i < numberOfCharacters; i++) {
            ImageView unitBackgroundView = new ImageView(unitBackground);
            unitBackgroundView.setFitWidth(200);
            unitBackgroundView.setPreserveRatio(true);
            backgroundHBox.getChildren().add(unitBackgroundView);
        }
    }


    
}
