package battle.utils;

import battle.entities.Animal;
import battle.entities.Cat;
import battle.entities.Dog;
import battle.entities.Monkey;

public class CreateFighter {

    private CreateFighter() {
    }

    public static Animal createAnimal(String animalParameters) {

        Animal createdAnimal;

        String[] arrayParameters = animalParameters.split(" ");

        if (arrayParameters[0].equals("Cat")) {
            createdAnimal = new Cat(arrayParameters[1]
                    , Integer.parseInt(arrayParameters[2])
                    , Integer.parseInt(arrayParameters[3]));
        } else if (arrayParameters[0].equals("Dog")) {
            createdAnimal = new Dog(arrayParameters[1]
                    , Integer.parseInt(arrayParameters[2])
                    , Integer.parseInt(arrayParameters[3]));
        } else if (arrayParameters[0].equals("Monkey")) {
            createdAnimal = new Monkey(arrayParameters[1]
                    , Integer.parseInt(arrayParameters[2])
                    , Integer.parseInt(arrayParameters[3]));
        }else {
            createdAnimal = new Cat(arrayParameters[1]
                    , Integer.parseInt(arrayParameters[2])
                    , Integer.parseInt(arrayParameters[3]));
        }

        return createdAnimal;
    }

}
