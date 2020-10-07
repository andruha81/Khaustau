package battle.utils;

import battle.api.services.IFightersService;
import battle.entities.Animal;
import org.apache.commons.lang3.RandomUtils;

public class Combat {

    private static int serialAttacks = 1;            // Серия атак
    private static int round;                    // Номер хода
    private static Animal winner;
    private static Animal attacker;
    private static Animal defender;

    private Combat() {
    }

    public static Animal startCombat(Animal firstFighter, Animal secondFighter, IFightersService fightersService) {

        winner = null;
        attacker = null;
        defender = null;
        round = 1;
        serialAttacks = 1;

        while (winner == null) {
            chooseWhoAttack(firstFighter, secondFighter);

            fightersService.editFighterHealth(defender, attack());

            checkWinner();
        }

        fightersService.setFighterHealthDefault(attacker);
        fightersService.setFighterHealthDefault(defender);

        return winner;
    }

    private static void chooseWhoAttack(Animal firstFighter, Animal secondFighter) {
        System.out.println("******* ROUND" + round + " *******");
        round++;

        if (attacker == null) {
            if (RandomUtils.nextInt(0, 2) == 0) {
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

    private static boolean checkLuckyAttack() {
        return (RandomUtils.nextInt(1, 5 * serialAttacks) == 5);
    }

    private static int attack() {
        int damage = (attacker.getForce() - defender.getAgility());
        damage = Math.max(damage, 1);

        System.out.println(defender.getFullName() + " is damaged by " + damage);

        return damage;

    }

    private static void checkWinner() {
        if (defender.getHealth() == 0) {
            winner = attacker;
            System.out.println("******* ENF OF THE BATTLE *******");
            System.out.println("The winner is " + attacker.getFullName());
        }
    }
}
