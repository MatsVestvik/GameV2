package com.game.createView;

import com.game.logic.MakeImage;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration; 

public class ViewCharacter {

    StackPane charPane;
    private Group characterGroup;
    private Group backGroundGroup;
    boolean isPlayer;
    private ImageView unitBackgroundView;


    public ViewCharacter(boolean isPlayer, Image avatar) {
        charPane = new StackPane();
        this.isPlayer = isPlayer;  
        if (!isPlayer) {
            flipCharacterView();
        }
        Image unitBackground = MakeImage.createImage("img/elements/UnitBackground.gif");
        ImageView unitBackgroundView = new ImageView(unitBackground);
        unitBackgroundView.setFitWidth(200);
        unitBackgroundView.setPreserveRatio(true);
        this.unitBackgroundView = unitBackgroundView;
        backGroundGroup = new Group();
        

        backGroundGroup.getChildren().add(unitBackgroundView);
        characterGroup = new Group();

        ImageView avatarView = new ImageView(avatar);
        avatarView.setFitWidth(200);
        avatarView.setPreserveRatio(true);
        characterGroup.getChildren().add(avatarView);

        charPane.getChildren().addAll(backGroundGroup, characterGroup);
    }

    public StackPane getCharPane() {
        return charPane;
    }

    public void addImageToPane(Image img) {
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        characterGroup.getChildren().add(imageView);
    }

    public void addImageViewToPane(ImageView imgView) {
        charPane.getChildren().add(imgView);
    }

    public void addItemImageToPane(Image img, int rarity) {
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        ImageView raredImg = RarityFilter.applyRarityTint(imageView, rarity);
        characterGroup.getChildren().add(raredImg);
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

    public void killCharacterView() {
        characterGroup.getChildren().clear();
        Image deadImage = MakeImage.createImage("img/elements/Death.png");
        ImageView deadImageView = new ImageView(deadImage);
        deadImageView.setFitWidth(200); 
        deadImageView.setPreserveRatio(true);
        characterGroup.getChildren().add(deadImageView);
    }

    public void attackAnimation() {
        Timeline timeline = new Timeline();
        
        // KeyFrame 1: Move to attack position
        KeyValue kv1 = new KeyValue(characterGroup.translateXProperty(), 
                                    isPlayer ? 20 : -20);
        KeyFrame kf1 = new KeyFrame(Duration.millis(50), kv1);
        
        // KeyFrame 2: Return to original position
        KeyValue kv2 = new KeyValue(characterGroup.translateXProperty(), 0);
        KeyFrame kf2 = new KeyFrame(Duration.millis(200), kv2);
        
        timeline.getKeyFrames().addAll(kf1, kf2);
        timeline.play();
    }

    public void hurtAnimation() {
        Timeline timeline = new Timeline();
        characterGroup.color
        
        // KeyFrame 1: Move to hurt position
        KeyValue kv1 = new KeyValue(characterGroup.translateYProperty(), 
                                    isPlayer ? -10 : 10);
        KeyFrame kf1 = new KeyFrame(Duration.millis(50), kv1);
        
        // KeyFrame 2: Return to original position
        KeyValue kv2 = new KeyValue(characterGroup.translateYProperty(), 0);
        KeyFrame kf2 = new KeyFrame(Duration.millis(200), kv2);
        
        timeline.getKeyFrames().addAll(kf1, kf2);
        timeline.play();
    }
}
