package com.game.scenes;

import com.game.CreateEnemies;
import com.game.CreateHero;
import com.game.createView.FightView;
import com.game.createView.StatsView;
import com.game.createView.ViewCharacter;
import com.game.createView.inventory.EquippedGrid;
import com.game.createView.inventory.InventoryGrid;
import com.game.logic.Item;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;

public class FightScreen {
    VBox allElementsVBox;
    private Stage stage;

    public FightScreen(Stage stage) {
        this.stage = stage;
        stage.setMaximized(true);
        allElementsVBox = new VBox();
    }

    public VBox getAllElementsVBox() {return allElementsVBox;}
    
    public Scene createFightScene(Scene endScene) {
        CreateHero heroCreator = new CreateHero();
        EquippedGrid equippedGrid = new EquippedGrid(4,2, 100);
        InventoryGrid inventoryGrid = new InventoryGrid(5,13, 75);

        ViewCharacter yourPlayerView = heroCreator.CreateMainCharacter(inventoryGrid, equippedGrid);

        CreateEnemies enemyCreator = new CreateEnemies();

        FightView fightView = new FightView(yourPlayerView, enemyCreator.getEnemyView(0), enemyCreator.getEnemyView(1), enemyCreator.getEnemyView(2));
        StackPane fightPane = fightView.getFightPane();

        StatsView statsView = new StatsView(
            yourPlayerView.getCharacter(),
            enemyCreator.getEnemyView(0).getCharacter(),
            enemyCreator.getEnemyView(1).getCharacter(),
            enemyCreator.getEnemyView(2).getCharacter()
        );

        enemyCreator.getEnemyView(0).getInvisibleButton().setOnAction(e -> {
            System.out.println("Enemy 1 clicked");
            fightView.attackAndHurtAnimation(yourPlayerView, enemyCreator.getEnemyView(0));
            statsView.updateStats(1);
            if (statsView.areAllEnemiesDefeated()) {
                stage.setScene(endScene);
            }
        });

        enemyCreator.getEnemyView(1).getInvisibleButton().setOnAction(e -> {
            System.out.println("Enemy 2 clicked");
            fightView.attackAndHurtAnimation(yourPlayerView, enemyCreator.getEnemyView(1));
            statsView.updateStats(2);
            if (statsView.areAllEnemiesDefeated()) {
                stage.setScene(endScene);
            }
        });

        enemyCreator.getEnemyView(2).getInvisibleButton().setOnAction(e -> {
            System.out.println("Enemy 3 clicked");
            fightView.attackAndHurtAnimation(yourPlayerView, enemyCreator.getEnemyView(2));
            statsView.updateStats(3);
            if (statsView.areAllEnemiesDefeated()) {
                stage.setScene(endScene);
            }
        });
        equippedGrid.setOnSlotClicked((slotIndex, itemData) -> {
            System.out.println("unequipping slot: " + slotIndex);
            equippedGrid.removeItemFromSlot(slotIndex);
            inventoryGrid.addItemToFirstAvailable((Item) itemData);
            heroCreator.getHero().unequipItem((Item) itemData);
            heroCreator.getHeroView().removeImageFromPane(((Item) itemData).getType());
            statsView.updateStats(0);
        });
        inventoryGrid.setOnSlotClicked((slotIndex, itemData) -> {
            System.out.println("equipping slot: " + slotIndex);
            inventoryGrid.removeItemFromSlot(slotIndex);
            if (equippedGrid.isSlotEmpty(equippedGrid.indexOfType((Item) itemData))) {
                equippedGrid.addItemToSlot((Item) itemData);
                heroCreator.getHero().equipItem((Item) itemData);
                heroCreator.getHeroView().addItemImageToPane(((Item) itemData).getIcon(), ((Item) itemData).getRarity(), ((Item) itemData).getType());
                statsView.updateStats(0);
            }
            else {
                inventoryGrid.addItemToFirstAvailable(equippedGrid.getItemFromSlot(equippedGrid.indexOfType((Item) itemData)));
                equippedGrid.removeItemFromSlot(equippedGrid.indexOfType((Item) itemData));
                equippedGrid.addItemToSlot((Item) itemData);
                heroCreator.getHero().unequipItem(equippedGrid.getItemFromSlot(equippedGrid.indexOfType((Item) itemData)));
                heroCreator.getHero().equipItem((Item) itemData);  
                heroCreator.getHeroView().removeImageFromPane(((Item) itemData).getType());
                heroCreator.getHeroView().addItemImageToPane(((Item) itemData).getIcon(), ((Item) itemData).getRarity(), ((Item) itemData).getType());
                statsView.updateStats(0);
            }
            
        });
        


        HBox inventoryHBox = new HBox();
        inventoryHBox.getChildren().addAll(equippedGrid.getGrid(), inventoryGrid.getGrid());
        

        allElementsVBox.getChildren().addAll(fightPane, statsView.getStatsHBox(), inventoryHBox);
        stage.setMaximized(true);

        Scene fightScene = new Scene(allElementsVBox, stage.getWidth(), Screen.getPrimary().getBounds().getHeight());
        return fightScene;
    }
}
