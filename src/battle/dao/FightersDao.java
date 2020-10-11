package battle.dao;

import battle.api.dao.IFightersDao;
import battle.entities.Animal;

import java.util.ArrayList;
import java.util.List;

public class FightersDao implements IFightersDao {

    private final List<Animal> fighters = new ArrayList<>();

    @Override
    public void addFighters(List<Animal> fightersReadFromFile) {
        fighters.addAll(fightersReadFromFile);
    }

    @Override
    public List<Animal> getFighters() {
        return fighters;
    }
}
