package battle.services;

import battle.api.exceptions.NullNumberException;
import battle.api.services.IChampionship;
import battle.api.services.ICombat;
import battle.api.services.IFightersService;
import battle.entities.Animal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Championship implements IChampionship {

    private int numberOfCombats;
    private int maxNumberOfVictories;
    private final IFightersService fightersService = new FightersService();
    private final ICombat combat = new Combat();
    private List<Animal> fightersReady;

    @Override
    public void start(int numberOfFighters) {

        System.out.println("============START OF THE CHAMPIONSHIP++++++++++++++++");

        for (int i = 1; i <= numberOfFighters; i++) {

            fightersService.addFighter();

        }

        fightersReady = new ArrayList<>(fightersService.getFighters().values());

    }

    @Override
    public void startCombat() {

        for (int i = 0; i < fightersReady.size() - 1; i++) {
            for (int j = i + 1; j < fightersReady.size(); j++) {

                numberOfCombats++;

                System.out.println("----------------------------------");
                System.out.println("-                                -");
                System.out.println("-         COMBAT " + numberOfCombats + "               -");
                System.out.println("-                                -");
                System.out.println("----------------------------------");

                combat.startCombat(fightersReady.get(i), fightersReady.get(j)).editVictories();

            }
        }
    }

    @Override
    public boolean checkWinner() {

        try {
            findMaxNumberOfVictories();
        } catch (NullNumberException e) {
            maxNumberOfVictories = 0;
        }

        fightersReady = fightersService.getFighters()
                .values()
                .stream()
                .filter(x -> x.getVictories() == maxNumberOfVictories)
                .collect(Collectors.toList());

        if (fightersReady.size() == 1) {

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("The winner of the championship is " + fightersReady.get(0).getFullName());
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            return true;

        } else if (maxNumberOfVictories == 0){

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("The championship was cancelled");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            return true;

        } else {

            return false;

        }
    }

    @Override
    public void printResults() {

        System.out.println("##############RESULTS#############");

        fightersService.getFighters()
                .values()
                .stream()
                .sorted(Comparator.comparing(Animal::getVictories))
                .forEach(x -> System.out.println(x.getFullName() + " - " + x.getVictories() + " victories"));
        System.out.println("##################################");

    }

    private void findMaxNumberOfVictories() throws NullNumberException {

        maxNumberOfVictories = fightersService.getFighters()
                .values()
                .stream()
                .mapToInt(Animal::getVictories)
                .max()
                .orElseThrow(NullNumberException::new);

    }

}
