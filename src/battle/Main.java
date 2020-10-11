package battle;

import battle.api.services.IChampionship;
import battle.services.Championship;

public class Main {

    public static void main(String[] args) {

        IChampionship championship = new Championship();

        if (championship.start()) {

            System.out.println("Championship started");

            do {

                championship.startCombats();

                championship.printResults();

            } while (!championship.checkWinner());

            championship.SaveResultsToFile();

        } else {

            System.out.println("None fighters were found. Championship didn't start");
        }
    }
}