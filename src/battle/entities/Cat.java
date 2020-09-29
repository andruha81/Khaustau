package battle.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Cat extends Animal {

    public Cat(String newName) {
        super(newName);

        this.typeOfAnimal = TypeOfAnimals.CAT;
        this.force = ThreadLocalRandom.current().nextInt(3, 7);
        this.agility = ThreadLocalRandom.current().nextInt(4, 8);
    }

}