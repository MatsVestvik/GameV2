package com.game.createView;

import java.security.Key;
import java.sql.Time;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;

import com.game.createView.ViewCharacter;
import com.game.logic.Character;

public class FightView {

    public FightView() {
        
    }
    public void attackAnimation(ViewCharacter attacker) {
        attacker.attackAnimation();
    }

    public void hurtAnimation(ViewCharacter defender) {
        defender.hurtAnimation();
    }

    public void attackAndHurtAnimation(ViewCharacter attacker, ViewCharacter defender) {
        Timeline timeline = new Timeline();
        int damageDealt = attacker.getCharacter().getTotalDamage() - defender.getCharacter().getTotalArmor();
        defender.getCharacter().setHealth(defender.getCharacter().getHealth() - damageDealt);

        KeyFrame duration = new KeyFrame(Duration.millis(50), e -> {
            attacker.attackAnimation();
        });
        KeyFrame duration2 = new KeyFrame(Duration.millis(100), e -> {
            defender.hurtAnimation();
        });
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
}
