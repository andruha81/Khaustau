package battle.services;

import battle.api.services.IFightersService;
import battle.dao.FightersDao;
import battle.entities.Animal;
import battle.entities.Cat;
import battle.entities.Dog;
import battle.entities.Monkey;
import battle.utils.Names;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class FightersService implements IFightersService {

    private final FightersDao fightersDao = new FightersDao();

    @Override
    public void addFighter() {
        fightersDao.addFighter(chooseFighter());
    }

    @Override
    public Map<String, Animal> getFighters() {
        return fightersDao.getFighters();
    }

    @Override
    public void editVictories(Animal fighter) {
        fightersDao.editVictories(fighter);
    }

    private Animal chooseFighter() {

        Animal randomFighter;

        int randNumberOfFighter = ThreadLocalRandom.current().nextInt(1, 4);

        String name;

        do {

            name = Names.createName();

        } while (Names.checkNameRepeat(fightersDao.getFighters(),name));

        switch (randNumberOfFighter) {
            case 1:
                randomFighter = new Cat(name);
                break;

            case 2:
                randomFighter = new Dog(name);
                break;

            case 3:
                randomFighter = new Monkey(name);
                break;

            default:
                randomFighter = new Cat(name);
        }

        return randomFighter;
    }

}