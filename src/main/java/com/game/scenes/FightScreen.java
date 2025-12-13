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
import javafx.stage.Stage;

public class FightScreen {
    VBox allElementsVBox;

    public FightScreen() {
        allElementsVBox = new VBox();
    }

    public VBox getAllElementsVBox() {return allElementsVBox;}
    
    public Scene createFightScene(Stage stage) {
        CreateHero heroCreator = new CreateHero();
        ViewCharacter yourPlayerView = heroCreator.CreateMainCharacter();

        CreateEnemies enemyCreator = new CreateEnemies();

        FightView fightView = new FightView(yourPlayerView, enemyCreator.getEnemyView(0), enemyCreator.getEnemyView(1), enemyCreator.getEnemyView(2));
        StackPane fightPane = fightView.getFightPane();

        enemyCreator.getEnemyView(0).getInvisibleButton().setOnAction(e -> {
            System.out.println("Enemy 1 clicked");
            fightView.attackAndHurtAnimation(yourPlayerView, enemyCreator.getEnemyView(0));
        });

        enemyCreator.getEnemyView(1).getInvisibleButton().setOnAction(e -> {
            fightView.attackAndHurtAnimation(yourPlayerView, enemyCreator.getEnemyView(1));
        });

        enemyCreator.getEnemyView(2).getInvisibleButton().setOnAction(e -> {
            fightView.attackAndHurtAnimation(yourPlayerView, enemyCreator.getEnemyView(2));
        });

        StatsView statsView = new StatsView(
            yourPlayerView.getCharacter(),
            enemyCreator.getEnemyView(0).getCharacter(),
            enemyCreator.getEnemyView(1).getCharacter(),
            enemyCreator.getEnemyView(2).getCharacter()
        );

        allElementsVBox.getChildren().addAll(fightPane, statsView.getStatsHBox());

        Scene fightScene = new Scene(allElementsVBox);
        return fightScene;
    }
}
