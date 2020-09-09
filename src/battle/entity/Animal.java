package battle.entity;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {

    protected String name;
    protected String typeOfAnimal;
    protected BigDecimal force;                                             // Сила, влияет на велечину атаки
    protected BigDecimal agility;                                           // Ловкость, влияет на способность увернутся от атаки и уменьшить урон
    protected BigDecimal endurance = new BigDecimal("1.0");             // Выносливость, чем она меньше, тем меньше сила и ловкость
    protected BigDecimal minEndurance = new BigDecimal("0.1");          // Минимальная выносливость
    protected BigDecimal rateDecreaseEndurance;                             // Коэффициент уменьшения выносливости после каждого хода
    protected BigDecimal health = new BigDecimal("10");                 // Здоровье

    public Animal(String newName) {
        this.name = newName;
        this.rateDecreaseEndurance = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(0.05, 0.15)).round(new MathContext(1));
    }

    public String getName() {
        return (typeOfAnimal + " " + name);
    }

    public BigDecimal getForce() {
        return force;
    }

    public BigDecimal getAgility() {
        return agility;
    }

    public BigDecimal getEndurance() {
        return endurance;
    }

    /*
     * Уменьшение выносливости после каждого хода
     */
    public void setEndurance() {
        this.endurance = endurance.subtract(rateDecreaseEndurance);
        if (endurance.compareTo(minEndurance) <= 0) {
            endurance = minEndurance;
        }
    }

    public BigDecimal getHealth() {
        return health;
    }

    /*
     * Уменьшение здоровья на велечину урона
     */
    public void setHealth(BigDecimal healthDamage) {
        this.health = health.subtract(healthDamage);
        if (health.compareTo(BigDecimal.ZERO) == -1) {
            this.health = BigDecimal.ZERO;
        }
    }

    /*
     * Вывод информации об участнике
     */
    public void printFighter(int fighterNumber) {
        System.out.println("Fighter " + fighterNumber + " " + getName());
        System.out.println("Force: " + force + ", Agility: " + agility + ", Rate decrease of endurance: " + rateDecreaseEndurance);
    }
}
