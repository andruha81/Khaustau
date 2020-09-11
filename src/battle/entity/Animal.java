package battle.entity;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {

    protected String name;
    protected String typeOfAnimal;
    protected int force;                                             // Сила, влияет на велечину атаки
    protected int agility;                                           // Ловкость, влияет на способность увернутся от атаки и уменьшить урон
    protected int endurance = 5;                                    // Выносливость, чем она меньше, тем меньше сила и ловкость
    protected int rateDecreaseEndurance;                             // Коэффициент уменьшения выносливости после каждого хода
    protected int health = 20;                                      // Здоровье

    public Animal(String newName) {
        this.name = newName;
        this.rateDecreaseEndurance = ThreadLocalRandom.current().nextInt(1, 2);
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

    public int getEndurance() {
        return endurance;
    }

    /*
     * Уменьшение выносливости после каждого хода
     */
    public void setEndurance() {
        this.endurance -= rateDecreaseEndurance;
        this.endurance = Math.max(endurance, 1);
    }

    public int getHealth() {
        return health;
    }

    /*
     * Уменьшение здоровья на велечину урона
     */
    public void setHealth(int healthDamage) {
        this.health -= healthDamage;
        this.health = Math.max(this.health, 0);
    }

    /*
     * Вывод информации об участнике
     */
    public void printFighter(int fighterNumber) {
        System.out.println("Fighter " + fighterNumber + " " + getName());
        System.out.println("Force: " + force + ", Agility: " + agility + ", Rate decrease of endurance: " + rateDecreaseEndurance);
    }
}
