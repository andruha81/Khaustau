package battle;

import battle.api.services.IChampionship;
import battle.services.Championship;

public class Main {

    public static void main(String[] args) {

        int numberOfFighters = 4;    // Setting number of fighters
        IChampionship championship = new Championship();


        championship.start(numberOfFighters);

        do {

            championship.startCombat();

            championship.printResults();

        } while (!championship.checkWinner());

    }
}