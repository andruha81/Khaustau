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
    protected int victories = 0;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.typeOfAnimal + " " + name + ", victories: " + victories
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

    public void editVictories() {
        this.victories++;
    }

}
