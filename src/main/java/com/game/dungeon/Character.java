package com.game.dungeon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class Character {
    private Image characterImage;
    private ImageView characterImageView;
    private int health;
    private int attack;

    public Character() {
        this.characterImage = new Image("img/basic/character/Basic_Character.gif"); 
        this.characterImageView = new ImageView(characterImage);
        characterImageView.setFitWidth(Screen.getPrimary().getBounds().getWidth() / 4);
        characterImageView.setFitHeight(Screen.getPrimary().getBounds().getWidth() / 4);
        health = 100;
        attack = 10;
    }

    public Image getCharacterImage() {return characterImage;}
    public ImageView getCharacterImageView() {return characterImageView;}
    public int getHealth() {return health;}
    public int getAttack() {return attack;}
}
