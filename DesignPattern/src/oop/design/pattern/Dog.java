package oop.design.pattern;

/**
 * Created by Phil on 01/07/2014.
 */
public class Dog extends Animal {

    public void digHole() {
        System.out.println("Dug a hole");
    }

    public Dog() {
        super();
        setSound("Bark");
        flyingType = new CantFly();
    }

    public void changeVar(int randNum) {
        randNum = 12;
        System.out.println("randNum in method: " + randNum);
    }
}
