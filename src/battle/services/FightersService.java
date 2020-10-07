package battle.services;

import battle.api.services.IFightersService;
import battle.dao.FightersDao;
import battle.entities.Animal;
import battle.utils.InputOutput;

import java.util.Map;

public class FightersService implements IFightersService {

    private final FightersDao fightersDao = new FightersDao();

    @Override
    public void addFighters() {

        InputOutput.readFile(InputOutput.enterPath(), fightersDao);

    }

    @Override
    public Map<String, Animal> getFighters() {
        return fightersDao.getFighters();
    }

    @Override
    public void setFighterHealthDefault(Animal fighter) {
        fightersDao.setFighterHealthDefault(fighter);
    }

    @Override
    public void editFighterHealth(Animal fighter, int healthDamage) {
        fightersDao.editFighterHealth(fighter, healthDamage);
    }

}