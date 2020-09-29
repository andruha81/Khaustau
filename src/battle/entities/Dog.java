package battle.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Dog extends Animal {

    public Dog(String newName) {
        super(newName);

        this.typeOfAnimal = TypeOfAnimals.DOG;
        this.force = ThreadLocalRandom.current().nextInt(6, 11);
        this.agility = ThreadLocalRandom.current().nextInt(1, 4);
    }
}