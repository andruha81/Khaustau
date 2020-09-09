package battle.entity;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class Monkey extends Animal{

    public Monkey(String newName) {
        super(newName);

        this.typeOfAnimal = "Monkey";
        setForceAgility();
    }

    public void setForceAgility() {
        this.force = BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(4,8));
        this.agility = BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(4,8));
    }
}