package com.game.createView;

import com.game.logic.MakeImage;
import com.game.logic.Character;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
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
    private Character character;


    public ViewCharacter(boolean isPlayer, Image avatar, Character character) {
        charPane = new StackPane();
        this.isPlayer = isPlayer;  
        this.character = character;
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

    public StackPane getCharPane() {return charPane;}
    public Group getCharacterGroup() {return characterGroup;}
    public Group getBackGroundGroup() {return backGroundGroup;}
    public Character getCharacter() {return character;}

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
        boolean isPlayer = this.isPlayer;
        int direction;
        if (isPlayer) {
            direction = 1;
        } else {
            direction = -1;
        }
        
        // KeyFrame 1: Move to attack position
        KeyValue kv1 = new KeyValue(characterGroup.translateXProperty(), 
                                    isPlayer ? 70*direction : -70*direction);
        KeyFrame kf1 = new KeyFrame(Duration.millis(150), kv1);
        
        // KeyFrame 2: Return to original position
        KeyValue kv2 = new KeyValue(characterGroup.translateXProperty(), 0);
        KeyFrame kf2 = new KeyFrame(Duration.millis(200), kv2);
        
        timeline.getKeyFrames().addAll(kf1, kf2);
        timeline.play();
    }

    public void hurtAnimation() {
        // Create a ColorAdjust effect for red tint
        ColorAdjust redTint = new ColorAdjust();
        redTint.setHue(0.0);      // Red hue
        redTint.setSaturation(1.0); // Increase saturation
        redTint.setBrightness(0.2); // Slightly brighten
        
        Timeline timeline = new Timeline();
        
        // Apply red tint immediately
        characterGroup.setEffect(redTint);
        
        // KeyFrame 1: Move up/down with full red tint
        KeyValue kv1 = new KeyValue(characterGroup.translateXProperty(), isPlayer ? -10 : 10);

        KeyFrame kf1 = new KeyFrame(Duration.millis(50), kv1);
        
        // KeyFrame 2: Return to position, fade out red tint
        KeyValue kv2y = new KeyValue(characterGroup.translateXProperty(), 0);
        KeyValue kv2Brightness = new KeyValue(redTint.brightnessProperty(), 0.0);
        KeyValue kv2Saturation = new KeyValue(redTint.saturationProperty(), 0.0);
        KeyFrame kf2 = new KeyFrame(Duration.millis(200), event -> characterGroup.setEffect(null), kv2y, kv2Brightness, kv2Saturation);
        
        timeline.getKeyFrames().addAll(kf1, kf2);
        timeline.play();
    }
}
