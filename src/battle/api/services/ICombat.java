package battle.api.services;

import battle.entities.Animal;

public interface ICombat {
    Animal startCombat(Animal animal1, Animal animal2);
}
