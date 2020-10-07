package battle.api.services;

import battle.entities.Animal;

import java.util.Map;

public interface IFightersService {

    void addFighters();

    Map<String, Animal> getFighters();

    void setFighterHealthDefault(Animal fighter);

    void editFighterHealth(Animal fighter, int healthDamage);

}
