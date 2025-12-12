package com.game.createView;

import com.game.logic.MakeImage;

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

    public void addImageViewToPane(ImageView imgView) {
        charPane.getChildren().add(imgView);
    }

    public void addItemImageToPane(Image img, int rarity) {
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        ImageView raredImg = RarityFilter.applyRarityTint(imageView, rarity);
        charPane.getChildren().add(raredImg);
    }

    public void flipCharacterView() {
        charPane.setScaleX(-1);
    }

    public void removeImageFromPane(Image img) {
        for (var node : charPane.getChildren()) {
            if (node instanceof ImageView) {
                ImageView iv = (ImageView) node;
                if (iv.getImage().equals(img)) {
                    charPane.getChildren().remove(iv);
                    break;
                }
            }
        }
    }

    public void clearPane() {
        charPane.getChildren().clear();
    }

    public void killCharacterView() {
        clearPane();
        Image unitBackground = MakeImage.createImage("img/elements/UnitBackground.gif");
        Image deathIcon = MakeImage.createImage("img/elements/Death.png");
        addImageToPane(unitBackground);
        addImageToPane(deathIcon);
    }
}
