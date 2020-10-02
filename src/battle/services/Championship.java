package battle.services;

import battle.api.services.IChampionship;
import battle.api.services.ICombat;
import battle.api.services.IFightersService;
import battle.entities.Animal;

import java.util.*;
import java.util.stream.Collectors;

public class Championship implements IChampionship {

    private int numberOfCombats;
    private final IFightersService fightersService = new FightersService();
    private final ICombat combat = new Combat();
    private final Map<Animal, Integer> championshipTable = new LinkedHashMap<>();
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
    public void startCombats() {

        for (int i = 0; i < fightersReady.size() - 1; i++) {
            for (int j = i + 1; j < fightersReady.size(); j++) {

                numberOfCombats++;

                System.out.println("---------COMBAT " + numberOfCombats + "-----------");

                Animal winner = combat.startCombat(fightersReady.get(i), fightersReady.get(j));

                championshipTable.put(winner, championshipTable.containsKey(winner) ? championshipTable.get(winner) + 1 : 1);

            }
        }
    }

    @Override
    public boolean checkWinner() {

        int maxNumberOfVictories = Collections.max(championshipTable.values());

        fightersReady = championshipTable.entrySet()
                .stream()
                .filter(x -> x.getValue() == maxNumberOfVictories)
                .map(x -> x.getKey())
                .collect(Collectors.toList());

        if (fightersReady.size() == 1) {

            System.out.println("The winner of the championship is " + fightersReady.get(0).getFullName());

            return true;

        } else if (maxNumberOfVictories == 0) {

            System.out.println("The championship was cancelled");

            return true;

        } else {

            return false;

        }
    }

    @Override
    public void printResults() {

        System.out.println("##############RESULTS#############");

        championshipTable.forEach((k, v) -> System.out.println(k.getFullName() + " - " + v + " victories"));

    }
}
