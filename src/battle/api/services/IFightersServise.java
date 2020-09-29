package battle.api.services;

import battle.entities.Animal;

import java.util.Map;

public interface IFightersServise {

    void addFighter();

    Map<String, Animal> getFighters();

    void editVictories(Animal fighter);

}
