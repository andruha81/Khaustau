package battle.entities;

public abstract class Animal {

    protected String name;
    protected String typeOfAnimal;
    protected int force;                                             // Сила, влияет на велечину атаки
    protected int agility;                                           // Ловкость, влияет на способность увернутся от атаки и уменьшить урон
    protected int health = 20;                                      // Здоровье

    public Animal(String newName) {
        this.name = newName;
    }

    public String getName() {
        return (typeOfAnimal + " " + name);
    }

    public int getForce() {
        return force;
    }

    public int getAgility() {
        return agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int healthDamage) {
        this.health -= healthDamage;
        this.health = Math.max(this.health, 0);
    }

    public void printFighter(int fighterNumber) {
        System.out.println("Fighter " + fighterNumber + " " + getName());
        System.out.println("Force: " + force + ", Agility: " + agility);
    }
}
