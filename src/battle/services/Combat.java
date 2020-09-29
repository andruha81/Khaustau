package battle.services;

import battle.api.services.ICombat;
import battle.entities.Animal;

import java.util.concurrent.ThreadLocalRandom;

public class Combat implements ICombat {

    private int serialAttacks = 1;            // Серия атак
    private int round = 1;                    // Номер хода
    private Animal winner;
    private Animal attacker;
    private Animal defender;

    public void startCombat(Animal firstFighter, Animal secondFighter) {
        while (winner == null) {
            chooseWhoAttack(firstFighter, secondFighter);
            attack();
            checkWinner();
        }
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
            System.out.println("Another chance to attack for " + attacker.getName());
            serialAttacks += 1;

        } else {
            Animal fighter = attacker;
            attacker = defender;
            defender = fighter;
            serialAttacks = 1;
        }

        System.out.println("Attacking " + attacker.getName() + ", defending " + defender.getName());
    }


    private boolean checkLuckyAttack() {
        return (ThreadLocalRandom.current().nextInt(1, 10 * serialAttacks) == 5);
    }

    private void attack() {
        int damage = (attacker.getForce() - defender.getAgility());
        damage = Math.max(damage, 1);

        System.out.println(defender.getName() + " is damaged by " + damage);

        defender.setHealth(damage);

        System.out.println(defender.getName() + " health is " + defender.getHealth());
    }

    private void checkWinner() {
        if (defender.getHealth() == 0) {
            winner = attacker;
            System.out.println("******* ENF OF THE BATTLE *******");
            System.out.println("The winner is " + attacker.getName());
        }
    }
}
