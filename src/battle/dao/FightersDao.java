package battle.dao;

import battle.api.dao.IFightersDao;
import battle.entities.Animal;

import java.util.LinkedHashMap;
import java.util.Map;

public class FightersDao implements IFightersDao {

    private Map<String, Animal> fighters = new LinkedHashMap<>();

    @Override
    public void addFighter(Animal fighter) {
        this.fighters.put(fighter.getName(), fighter);
    }
}
