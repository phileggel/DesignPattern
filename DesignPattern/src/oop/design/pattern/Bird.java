package oop.design.pattern;

/**
 * Created by Phil on 01/07/2014.
 */
public class Bird extends Animal {

    public Bird() {
        super();
        setSound("Tweet");
        flyingType = new ItFlys();
    }

}
