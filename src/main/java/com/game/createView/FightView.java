package com.game.createView;

public class FightView {

    public FightView() {
        
    }
    public void attackAnimation(ViewCharacter attacker) {
        attacker.attackAnimation();
    }

    public void hurtAnimation(ViewCharacter defender) {
        defender.hurtAnimation();
    }
}
