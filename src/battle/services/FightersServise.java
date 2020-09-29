package battle.services;

import battle.api.services.IFightersServise;
import battle.dao.FightersDao;
import battle.entities.Animal;
import battle.entities.Cat;
import battle.entities.Dog;
import battle.entities.Monkey;

import java.util.concurrent.ThreadLocalRandom;

public class FightersServise implements IFightersServise {

    FightersDao fightersDao = new FightersDao();

    @Override
    public void addFighter(Animal fighter) {
        fightersDao.addFighter(fighter);
    }

    private static Animal chooseFighter() {

        Animal randomFighter;
        int randNumberOfFighter = ThreadLocalRandom.current().nextInt(1, 4);

        switch (randNumberOfFighter) {
            case 1:
                randomFighter = new Cat("1");
                break;

            case 2:
                randomFighter = new Dog("1");
                break;

            case 3:
                randomFighter = new Monkey("1");
                break;

            default:
                randomFighter = new Cat("1");
        }

        return randomFighter;
    }
}