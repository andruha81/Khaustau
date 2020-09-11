package battle;

import battle.combat.Combat;
import battle.combat.ICombat;
import battle.entity.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final List<String> fighterNames = Arrays.asList("Rambo","Terminator","Killer","Mad","Dragon","Destroyer","Giant","Titan","Chack Norris","Ninja");

    public static void main(String[] args) {

        int numberOfCombats = 1;    // Setting number of combats
        ICombat combat;
        Animal firtsFighter;
        Animal secondFighter;

        /*
         * Starting combats in a loop
         */
        for (int i = 1; i < numberOfCombats + 1; i++) {
            combat = new Combat();

            System.out.println("Battle N_ " + i);

            /*
             * Choose randomly first fighter and print him
             */
            firtsFighter = chooseFighter();
            firtsFighter.printFighter(1);

            /*
             * Choose randomly sdecond fighter and print him
             * It could the same type of animal
             */
            secondFighter = chooseFighter();
            secondFighter.printFighter(2);

            /*
             * Starting combat
             */
            combat.startCombat(firtsFighter, secondFighter);

            System.out.println("--------------------------");

        }
    }

    /*
     *  Randomly choose name for a fighter from a list of names
     */
    private static String chooseName(){

        return fighterNames.get(ThreadLocalRandom.current().nextInt(0,fighterNames.size()));
    }

    /*
     * Randomly choose tyoe of an animal to fight
     */
    private static Animal chooseFighter() {

        Animal randomFighter;
        int randNumberOfFighter = ThreadLocalRandom.current().nextInt(1,4);

        switch (randNumberOfFighter) {
            case 1: randomFighter = new Cat(chooseName());
                break;

            case 2: randomFighter = new Dog(chooseName());
                break;

            case 3: randomFighter = new Monkey(chooseName());
                break;

            default: randomFighter = new Cat(chooseName());
        }

        return randomFighter;
    }
}