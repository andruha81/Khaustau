package battle;

import battle.api.services.IChampionship;
import battle.services.Championship;
import battle.utils.InputOutput;

public class Main {

    public static void main(String[] args) {

        IChampionship championship = new Championship();

        championship.start();

        do {

            championship.startCombats();

            championship.printResults();

        } while (!championship.checkWinner());

    }
}