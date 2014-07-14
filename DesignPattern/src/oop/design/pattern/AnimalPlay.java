package oop.design.pattern;

/**
 * Created by Phil on 01/07/2014.
 */

public class AnimalPlay {

    public static void main(String[] args) {

        Animal sparky = new Dog();
        Animal tweety = new Bird();

        System.out.println("oop.design.pattern.Dog: " + sparky.tryToFly());
        System.out.println("oop.design.pattern.Bird: " + tweety.tryToFly());
    }

}
