package com.game.createView;

import java.security.Key;
import java.sql.Time;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.text.View;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import com.game.createView.ViewCharacter;
import com.game.logic.Character;

public class FightView {

    private StackPane fightPane;
    private HBox fightHBox;


    public FightView(ViewCharacter player, ViewCharacter npc, ViewCharacter npc2, ViewCharacter npc3) {
        CharactersView charactersView = new CharactersView(player, npc, npc2, npc3);
        BackgroundView backgroundView = new BackgroundView(4);

        fightPane = new StackPane();

        fightPane.getChildren().addAll(backgroundView.getBackgroundHBox(), charactersView.getCharactersHBox());
    }

    public HBox getFightHBox() {return fightHBox;}
    public StackPane getFightPane() {return fightPane;}

    public void attackAnimation(ViewCharacter attacker) {
        attacker.attackAnimation();
    }

    public void hurtAnimation(ViewCharacter defender) {
        defender.hurtAnimation();
    }

    public void attackAndHurtAnimation(ViewCharacter attacker, ViewCharacter defender) {
        Timeline timeline = new Timeline();
        int damageDealt = attacker.getCharacter().getTotalDamage() - defender.getCharacter().getTotalArmor();
        if (damageDealt < 0) {
            damageDealt = 0;
        }
        defender.getCharacter().setHealth(defender.getCharacter().getHealth() - damageDealt);
        
        KeyFrame duration = new KeyFrame(Duration.millis(100), e -> {
            attacker.attackAnimation();
        });
        KeyFrame duration2 = new KeyFrame(Duration.millis(200), e -> {
            defender.hurtAnimation();
        });

        if (defender.getCharacter().getHealth() <= 0) {
            defender.killCharacterView();
        }

        timeline.getKeyFrames().addAll(duration, duration2);
        timeline.play();
    }

    public void startFight(ViewCharacter player, ViewCharacter npc) {
        Timeline timeline = new Timeline();
        AtomicInteger turn = new AtomicInteger(0);
        
        // Create a repeating KeyFrame
        KeyFrame fightFrame = new KeyFrame(Duration.millis(1000), e -> {
            int currentTurn = turn.getAndIncrement();
            
            if (player.getCharacter().getHealth() <= 0) {
                System.out.println(npc.getCharacter().getName() + " wins!");
                player.killCharacterView();
                timeline.stop();
                return;
            }
            
            if (npc.getCharacter().getHealth() <= 0) {
                System.out.println(player.getCharacter().getName() + " wins!");
                npc.killCharacterView();
                timeline.stop();
                return;
            }
            
            if (currentTurn % 2 == 0) {
                // Player's turn
                attackAndHurtAnimation(player, npc);
            } else {
                // NPC's turn
                attackAndHurtAnimation(npc, player);
            }
        });
        
        // Set timeline to repeat until stopped
        timeline.getKeyFrames().add(fightFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        
        // Start after initial delay
        PauseTransition delay = new PauseTransition(Duration.millis(500));
        delay.setOnFinished(e -> timeline.play());
        delay.play();
    }

    public void attackAndReact(ViewCharacter attacker, ViewCharacter defender, StatsView statsView) {
        Timeline timeline = new Timeline();
        
        KeyFrame attackFrame = new KeyFrame(Duration.millis(0), e -> {
            attackAndHurtAnimation(attacker, defender);
            System.out.println(attacker.getCharacter().getTotalDamage() +"-"+ defender.getCharacter().getTotalArmor()+ "="+ defender.getCharacter().getHealth());
            statsView.updateStats(1);
            statsView.updateStats(0);
        });
        
        KeyFrame hurtFrame = new KeyFrame(Duration.millis(500), e -> {
            attackAndHurtAnimation(defender, attacker);
            System.out.println(defender.getCharacter().getTotalDamage() +"-"+ attacker.getCharacter().getTotalArmor()+ "="+ attacker.getCharacter().getHealth());
            statsView.updateStats(2);
            statsView.updateStats(0);
        });
        
        timeline.getKeyFrames().addAll(attackFrame, hurtFrame);
        timeline.play();
    }
}
