package pattern.factory;

/**
 * Created by Phil on 02/07/2014.
 */

public abstract class EnemyShip {

    private String name;
    private double damage;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getDamage() {
        return damage;
    }
    public void setDamage(double amtDamage) {
        this.damage = amtDamage;
    }

    public void followHeroShip() {
        System.out.println(getName() + " is fallowing the hero");
    }

    public void displayEnemyShip() {
        System.out.println(getName() + " is on the screen");
    }

    public void enemyShipShoots() {
        System.out.println(getName() + " attacks and doe");
    }
}
