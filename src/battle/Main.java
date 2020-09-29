package battle;

import battle.api.services.ICombat;
import battle.api.services.IFightersServise;
import battle.entities.Animal;
import battle.services.Combat;
import battle.services.FightersServise;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int numberOfFighters = 5;    // Setting number of fighters

        IFightersServise fightersServise = new FightersServise();

        ICombat combat = new Combat();

        for (int i = 1; i <= numberOfFighters; i++) {

            fightersServise.addFighter();

        }

        List<Animal> fightersReady = new ArrayList<>(fightersServise.getFighters().values());

        for (int i = 0; i < fightersServise.getFighters().size() - 1; i++) {
            for (int j = i + 1; j < fightersServise.getFighters().size(); j++) {

                combat.startCombat(fightersReady.get(i), fightersReady.get(j)).editVictories();

            }
        }

        fightersServise.getFighters().values().forEach(x -> System.out.println(x.getName() + " victories: " + x.getVictories()));

    }
}