package battle;

import battle.api.services.ICombat;
import battle.api.services.IFightersServise;
import battle.entities.Animal;
import battle.entities.Cat;
import battle.entities.Dog;
import battle.entities.Monkey;
import battle.services.FightersServise;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        int numberOfFighters = 5;    // Setting number of fighters

        IFightersServise fightersServise = new FightersServise();

        ICombat combat;

        Animal firtsFighter;

        Animal secondFighter;

        for (int i = 1; i <= numberOfFighters; i++) {



        }
    }
}