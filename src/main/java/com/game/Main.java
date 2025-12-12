package com.game;

import com.game.logic.Character;
import com.game.logic.Fight;

public class Main{


    public static void main(String[] args) {
        Character hero = new Character("Hero", 100, 15);
        Character villain = new Character("Villain", 50, 12);

        Fight fight = new Fight();
        fight.fight(hero, villain);

    }
}