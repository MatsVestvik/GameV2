package com.game.createView;

import javafx.scene.layout.HBox;

public class CharactersView {
    HBox charactersHBox;

    public CharactersView(ViewCharacter yourPlayCharacter, ViewCharacter enemyCharacter) {
        charactersHBox = new HBox();
        charactersHBox.getChildren().addAll(yourPlayCharacter.getCharPane(), enemyCharacter.getCharPane());
    }

    public HBox getCharactersHBox() {return charactersHBox;}
}
