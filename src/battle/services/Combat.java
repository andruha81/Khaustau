package battle.services;

import battle.api.services.ICombat;
import battle.entities.Animal;

import java.util.concurrent.ThreadLocalRandom;

public class Combat implements ICombat {

    private int serialAttacks = 1;            // Серия атак
    private int round;                    // Номер хода
    private Animal winner;
    private Animal attacker;
    private Animal defender;

    public Animal startCombat(Animal firstFighter, Animal secondFighter) {

        winner = attacker = defender = null;
        round = 1;
        serialAttacks = 1;

        while (winner == null) {
            chooseWhoAttack(firstFighter, secondFighter);
            attack();
            checkWinner();
        }

        attacker.setHealthDefault();
        defender.setHealthDefault();
        return winner;
    }

    private void chooseWhoAttack(Animal firstFighter, Animal secondFighter) {
        System.out.println("******* ROUND" + round + " *******");
        round++;

        if (attacker == null) {
            if (ThreadLocalRandom.current().nextInt(0, 2) == 0) {
                attacker = firstFighter;
                defender = secondFighter;
            } else {
                attacker = secondFighter;
                defender = firstFighter;
            }

        } else if (checkLuckyAttack()) {
            System.out.println("Another chance to attack for " + attacker.getFullName());
            serialAttacks++;

        } else {
            Animal fighter = attacker;
            attacker = defender;
            defender = fighter;
            serialAttacks = 1;
        }

        System.out.println("Attacking " + attacker.getFullName() + ", defending " + defender.getFullName());
    }

    private boolean checkLuckyAttack() {
        return (ThreadLocalRandom.current().nextInt(1, 5 * serialAttacks) == 5);
    }

    private void attack() {
        int damage = (attacker.getForce() - defender.getAgility());
        damage = Math.max(damage, 1);

        System.out.println(defender.getFullName() + " is damaged by " + damage);

        defender.editHealth(damage);

        System.out.println(defender.getFullName() + " health is " + defender.getHealth());
    }

    private void checkWinner() {
        if (defender.getHealth() == 0) {
            winner = attacker;
            System.out.println("******* ENF OF THE BATTLE *******");
            System.out.println("The winner is " + attacker.getFullName());
        }
    }
}
