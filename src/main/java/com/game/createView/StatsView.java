package com.game.createView;

import java.util.List;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import com.game.logic.Character;

public class StatsView {
    HBox statsHBox;
    List<VBox> statsVBoxes;
    private double width = javafx.stage.Screen.getPrimary().getBounds().getWidth() / 4;

    public StatsView(Character mainCharacter, Character enemy1, Character enemy2, Character enemy3) {
        statsVBoxes = new java.util.ArrayList<>();
        statsHBox = new HBox();
        statsVBoxes.add(createStatsVBox(mainCharacter));
        statsVBoxes.add(createStatsVBox(enemy1));
        statsVBoxes.add(createStatsVBox(enemy2));
        statsVBoxes.add(createStatsVBox(enemy3));
        statsHBox.getChildren().addAll(statsVBoxes);
    }

    public HBox getStatsHBox() {return statsHBox;}

    public VBox createStatsVBox(Character character) {
        
        VBox statVBox = new VBox();
        int armor = character.getTotalArmor();
        int damage = character.getTotalDamage();
        int health = character.getHealth();

        Text nameText = new Text("Name: " + character.getName());
        Text healthText = new Text("Health: " + health);
        Text armorText = new Text("Armor: " + armor);
        Text damageText = new Text("Damage: " + damage);
        statVBox.getChildren().addAll(nameText, healthText, armorText, damageText);
        statVBox.setPrefWidth(width);
        return statVBox;
    }
    
}
