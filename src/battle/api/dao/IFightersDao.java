package battle.api.dao;

import battle.entities.Animal;

import java.util.Map;

public interface IFightersDao {

    void addFighter(Animal fighter);

    Map<String, Animal> getFighters();

    void setFighterHealthDefault(Animal fighter);

    void editFighterHealth(Animal fighter, int healthDamage);

    }
