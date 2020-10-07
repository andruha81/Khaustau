package battle.dao;

import battle.api.dao.IFightersDao;
import battle.entities.Animal;

import java.util.LinkedHashMap;
import java.util.Map;

public class FightersDao implements IFightersDao {

    private final Map<String, Animal> fighters = new LinkedHashMap<>();

    @Override
    public void addFighter(Animal fighter) {
        this.fighters.put(fighter.getName(), fighter);
        System.out.println("Fighter added: " + fighter.toString());
    }

    @Override
    public Map<String, Animal> getFighters() {
        return fighters;
    }

    @Override
    public void setFighterHealthDefault(Animal fighter) {
        fighter.setHealthDefault();
    }

    @Override
    public void editFighterHealth(Animal fighter, int healthDamage) {

        fighter.editHealth(healthDamage);

        System.out.println(fighter.getFullName() + " health is " + fighter.getHealth());;

    }

}
