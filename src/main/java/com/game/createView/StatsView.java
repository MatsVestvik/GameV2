package com.game.createView;

import java.util.List;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Node;
import com.game.logic.Character;

public class StatsView {
    HBox statsHBox;
    List<VBox> statsVBoxes;
    private List<Character> characters; // Store characters for reference
    private double width;

    public StatsView(Character mainCharacter, Character enemy1, Character enemy2, Character enemy3) {
        statsVBoxes = new java.util.ArrayList<>();
        characters = new java.util.ArrayList<>(); // Initialize characters list
        this.width = javafx.stage.Screen.getPrimary().getBounds().getWidth() / 4;

        // Store all characters in the list
        characters.add(mainCharacter);
        characters.add(enemy1);
        characters.add(enemy2);
        characters.add(enemy3);
        
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
        updateVBoxContent(statVBox, character);
        statVBox.setPrefWidth(width);
        return statVBox;
    }

    // Update a specific character's stats by index
    public void updateStats(int index) {
        if (index >= 0 && index < statsVBoxes.size() && index < characters.size()) {
            VBox statVBox = statsVBoxes.get(index);
            Character character = characters.get(index);
            updateVBoxContent(statVBox, character);
        } else {
            System.err.println("Invalid index for updateStats: " + index);
        }
    }
    
    // Update all characters' stats
    public void updateAllStats() {
        for (int i = 0; i < statsVBoxes.size(); i++) {
            updateStats(i);
        }
    }
    
    // Helper method to update VBox content
    private void updateVBoxContent(VBox vbox, Character character) {
        // Clear existing content
        vbox.getChildren().clear();
        
        // Get updated stats
        int armor = character.getTotalArmor();
        int damage = character.getTotalDamage();
        int health = character.getHealth();
        
        // Create updated text elements
        Text nameText = new Text("Name: " + character.getName());
        Text healthText = new Text("Health: " + health);
        Text armorText = new Text("Armor: " + armor);
        Text damageText = new Text("Damage: " + damage);
        
        // Add to VBox
        vbox.getChildren().addAll(nameText, healthText, armorText, damageText);
    }

    public boolean areAllEnemiesDefeated() {
        // Check if all enemies (characters at index 1, 2, 3) are defeated
        for (int i = 1; i < characters.size(); i++) {
            if (characters.get(i).getHealth() > 1) {
                return false; // At least one enemy is still alive
            }
        }
        return true; // All enemies are defeated
    }
}