package battle.entity;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class Cat extends Animal{

    public Cat(String newName) {
        super(newName);

        this.typeOfAnimal = "Cat";
        setForceAgility();
    }

    public void setForceAgility() {
        this.force = BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(3,7));
        this.agility = BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(5,9));
    }
}