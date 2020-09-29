package battle.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Monkey extends Animal {

    public Monkey(String newName) {
        super(newName);

        this.typeOfAnimal = TypeOfAnimals.MONKEY;
        this.force = ThreadLocalRandom.current().nextInt(4, 8);
        this.agility = ThreadLocalRandom.current().nextInt(2, 6);
    }
}