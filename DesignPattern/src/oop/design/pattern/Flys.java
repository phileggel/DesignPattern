package oop.design.pattern;

/**
 * Created by Phil on 01/07/2014.
 */
public interface Flys {
    String fly();
}

class ItFlys implements Flys {

    @Override
    public String fly() {
        return "Flying Hight";
    }
}

class CantFly implements Flys {

    @Override
    public String fly() {
        return "I can't fly";
    }
}