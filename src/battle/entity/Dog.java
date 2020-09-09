package battle.entity;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class Dog extends Animal{

    public Dog(String newName) {
        super(newName);

        this.typeOfAnimal = "Dog";
        setForceAgility();
    }

    public void setForceAgility() {
        this.force = BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(6,11));
        this.agility = BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(1,5));
    }
}