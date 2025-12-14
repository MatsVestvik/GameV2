package com.game.scenes;

import com.game.CreateEnemies;
import com.game.CreateHero;
import com.game.createView.FightView;
import com.game.createView.StatsView;
import com.game.createView.ViewCharacter;

import javafx.scene.Scene;
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
    
    public Scene createFightScene() {
        CreateHero heroCreator = new CreateHero();
        ViewCharacter yourPlayerView = heroCreator.CreateMainCharacter();

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
        });

        enemyCreator.getEnemyView(1).getInvisibleButton().setOnAction(e -> {
            System.out.println("Enemy 2 clicked");
            fightView.attackAndHurtAnimation(yourPlayerView, enemyCreator.getEnemyView(1));
            statsView.updateStats(2);
        });

        enemyCreator.getEnemyView(2).getInvisibleButton().setOnAction(e -> {
            System.out.println("Enemy 3 clicked");
            fightView.attackAndHurtAnimation(yourPlayerView, enemyCreator.getEnemyView(2));
            statsView.updateStats(3);
        });

        allElementsVBox.getChildren().addAll(fightPane, statsView.getStatsHBox());
        stage.setMaximized(true);

        Scene fightScene = new Scene(allElementsVBox, stage.getWidth(), Screen.getPrimary().getBounds().getHeight());
        return fightScene;
    }
}
