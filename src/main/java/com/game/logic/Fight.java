package com.game.logic;

public class Fight {
    
    
    public void attack(Character attacker, Character defender) {
        int damageDealt = attacker.getTotalDamage() - defender.getTotalArmor();
        if (damageDealt < 0) {
            damageDealt = 0;
        }
        if (defender.getHealth() - damageDealt < 0) {
            defender.setHealth(0);
        } else {
            defender.setHealth(defender.getHealth() - damageDealt);
        }
    }

    public boolean isDefeated(Character character) {
        return character.getHealth() <= 0;
    }

    public void fight(Character player, Character npc) {
        System.out.println(player.getName() + " Health: " + player.getHealth());
        System.out.println(npc.getName() + " Health: " + npc.getHealth());
        while (true) {
            attack(player, npc);
            System.out.println(player.getName() + " attacks " + npc.getName() + "!");
            System.out.println(npc.getName() + " Health: " + npc.getHealth());
            if (isDefeated(npc)) {
                System.out.println(player.getName() + " wins!");
                break;
            }
            attack(npc, player);
            System.out.println(npc.getName() + " attacks " + player.getName() + "!");
            System.out.println(player.getName() + " Health: " + player.getHealth());
            if (isDefeated(player)) {
                System.out.println(npc.getName() + " wins!");
                break;
            }
        }
    }
}
