package com.game.createView;

import com.game.logic.MakeImage;

import java.util.ArrayList;
import java.util.List;

import com.game.logic.Character;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.util.Duration; 

public class ViewCharacter {

    StackPane charPane;
    boolean isPlayer;
    private Character character;
    private double width = Screen.getPrimary().getBounds().getWidth() / 4;
    Button invisibleButton;
    private int layers;


    public ViewCharacter(boolean isPlayer, Image avatar, Character character) {
        charPane = new StackPane();
        this.isPlayer = isPlayer;  
        this.character = character;
        if (!isPlayer) {
            flipCharacterView();
        }

        ImageView avatarView = new ImageView(avatar);
        avatarView.setFitWidth(width);
        avatarView.setPreserveRatio(true);

        Text armourLayer = new Text("armour");
        armourLayer.setOpacity(0);
        Text shieldLayer = new Text("shield");
        shieldLayer.setOpacity(0);

        invisibleButton = new Button();
        invisibleButton.setMinWidth(width);
        invisibleButton.setMinHeight(width);
        invisibleButton.setOpacity(0);

        charPane.getChildren().add(0, avatarView);
        charPane.getChildren().add(1, armourLayer);
        charPane.getChildren().add(2, shieldLayer);
        charPane.getChildren().add(3, invisibleButton);
        this.layers = 3;
        charPane.setAlignment(Pos.TOP_CENTER);
    }

    public StackPane getCharPane() {return charPane;}
    public Character getCharacter() {return character;}
    public Button getInvisibleButton() {return invisibleButton;}

    public void addImageToPane(Image img) {
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(width);
        imageView.setPreserveRatio(true);
        charPane.getChildren().add(1, imageView);
    }

    public void addImageViewToPane(ImageView imgView) {
        charPane.getChildren().add(1, imgView);
    }

    public void addItemImageToPane(Image img, int rarity, String itemType) {
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(width);
        imageView.setPreserveRatio(true);
        ImageView raredImg = RarityFilter.applyRarityTint(imageView, rarity);
        
        // Store item type as user data for easy removal
        raredImg.setUserData(itemType);
        
        layers++;
        if (itemType.equals("OFFHAND")) {
            charPane.getChildren().add(layers-1, raredImg);
            return;
        }
        charPane.getChildren().add(1, raredImg);
    }

    public void flipCharacterView() {
        charPane.setScaleX(-1);
    }

    public boolean removeImageFromPane(String itemType) {
        if (itemType == null || charPane == null) {
            return false;
        }
        
        // Find and remove ImageView with matching itemType in userData
        for (int i = charPane.getChildren().size() - 1; i >= 0; i--) {
            javafx.scene.Node node = charPane.getChildren().get(i);
            
            if (node instanceof ImageView) {
                ImageView imageView = (ImageView) node;
                Object userData = imageView.getUserData();
                
                if (userData != null && userData.equals(itemType)) {
                    charPane.getChildren().remove(i);
                    layers--; // Decrement layers count
                    return true;
                }
            }
        }
        
        return false;
    }

    public void killCharacterView() {
        charPane.getChildren().clear();
        Image deadImage = MakeImage.createImage("img/elements/Death.png");
        ImageView deadImageView = new ImageView(deadImage);
        deadImageView.setFitWidth(width); 
        deadImageView.setPreserveRatio(true);
        charPane.getChildren().add(deadImageView);
    }

    public void attackAnimation() {
        Timeline timeline = new Timeline();
        boolean isPlayer = this.isPlayer;
        
        // KeyFrame 1: Move to attack position
        KeyValue kv1 = new KeyValue(charPane.translateXProperty(), 
                                    isPlayer ? 170 : -170);
        KeyFrame kf1 = new KeyFrame(Duration.millis(150), kv1);
        
        // KeyFrame 2: Return to original position
        KeyValue kv2 = new KeyValue(charPane.translateXProperty(), 0);
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
        charPane.setEffect(redTint);
        
        // KeyFrame 1: Move up/down with full red tint
        KeyValue kv1 = new KeyValue(charPane.translateXProperty(), isPlayer ? -10 : 10);

        KeyFrame kf1 = new KeyFrame(Duration.millis(50), kv1);
        
        // KeyFrame 2: Return to position, fade out red tint
        KeyValue kv2y = new KeyValue(charPane.translateXProperty(), 0);
        KeyValue kv2Brightness = new KeyValue(redTint.brightnessProperty(), 0.0);
        KeyValue kv2Saturation = new KeyValue(redTint.saturationProperty(), 0.0);
        KeyFrame kf2 = new KeyFrame(Duration.millis(200), event -> charPane.setEffect(null), kv2y, kv2Brightness, kv2Saturation);
        
        timeline.getKeyFrames().addAll(kf1, kf2);
        timeline.play();
    }
}
