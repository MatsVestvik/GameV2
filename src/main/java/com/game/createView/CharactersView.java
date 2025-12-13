package com.game.createView;

import javafx.scene.layout.HBox;

public class CharactersView {
    HBox charactersHBox;

    public CharactersView(ViewCharacter yourPlayCharacter, ViewCharacter enemyCharacter, ViewCharacter enemyCharacter2, ViewCharacter enemyCharacter3) {
        charactersHBox = new HBox();
        charactersHBox.getChildren().addAll(yourPlayCharacter.getCharPane(), enemyCharacter.getCharPane(), enemyCharacter2.getCharPane(), enemyCharacter3.getCharPane());
    }

    public HBox getCharactersHBox() {return charactersHBox;}
}
