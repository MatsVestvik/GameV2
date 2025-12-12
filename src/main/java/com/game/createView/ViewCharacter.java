package com.game.createView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ViewCharacter {

    StackPane charPane;
    boolean isPlayer;

    public ViewCharacter(boolean isPlayer) {
        charPane = new StackPane();  
        if (!isPlayer) {
            flipCharacterView();
        }
    }

    public StackPane getCharPane() {
        return charPane;
    }

    public void addImageToPane(Image img) {
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        charPane.getChildren().add(imageView);
    }

    public void flipCharacterView() {
        charPane.setScaleX(-1);
    }
}
