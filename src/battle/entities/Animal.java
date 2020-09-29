package battle.entities;

public abstract class Animal {

    protected String name;
    protected TypeOfAnimals typeOfAnimal;
    protected int force;                                             // Сила, влияет на велечину атаки
    protected int agility;                                           // Ловкость, влияет на способность увернутся от атаки и уменьшить урон
    protected int health = 10;                                      // Здоровье
    protected int victories = 0;

    public Animal(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public int getForce() {
        return this.force;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getHealth() {
        return this.health;
    }

    public int getVictories() {
        return this.victories;
    }

    public void setHealthDefault() {
        this.health = 10;
    }

    public void editHealth(int healthDamage) {
        this.health -= healthDamage;
        this.health = Math.max(this.health, 0);
    }

    public void editVictories() {
        this.victories++;
    }

    @Override
    public String toString() {
        return this.typeOfAnimal + " " + name + "\n" + "Force: " + force + ", Agility: " + agility;
    }
}
