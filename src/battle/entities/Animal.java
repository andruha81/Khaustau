package battle.entities;

import lombok.Getter;

@Getter
public abstract class Animal {

    private static final int DEFAULT_HEALTH = 10;
    protected String name;
    protected TypeOfAnimals typeOfAnimal;
    protected int force;
    protected int agility;
    protected int health = DEFAULT_HEALTH;

    public Animal(String name, int force, int agility) {

        this.name = name;
        this.force = force;
        this.agility = agility;
    }

    @Override
    public String toString() {
        return this.typeOfAnimal + " " + name
                + "\n" + "Force: " + force + ", Agility: " + agility;
    }

    public String getFullName() {
        return this.typeOfAnimal + " " + this.getName();
    }

    public void setHealthDefault() {
        this.health = DEFAULT_HEALTH;
    }

    public void editHealth(int healthDamage) {
        this.health -= healthDamage;
        this.health = Math.max(this.health, 0);
    }
}
