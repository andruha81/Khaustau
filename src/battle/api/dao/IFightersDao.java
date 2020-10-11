package battle.api.dao;

import battle.entities.Animal;

import java.util.List;

public interface IFightersDao {

    void addFighters(List<Animal> fightersReadFromFile);

    List<Animal> getFighters();
}
