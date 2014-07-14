package oop.design.pattern;

/**
 * Created by Phil on 01/07/2014.
 */
public class Girafe extends Creature {

    private String name;

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setHeight(double newheight) {

    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public void setWeight(double newWeight) {

    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public void setFavFood(String newFood) {

    }

    @Override
    public String getFavFood() {
        return null;
    }

    @Override
    public void setSpeed(double newSpeed) {

    }

    @Override
    public double getSpeed() {
        return 0;
    }

    @Override
    public void setSound(String newSound) {

    }

    @Override
    public String getSound() {
        return null;
    }
}
