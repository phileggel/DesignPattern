package pattern.decorator;

/**
 * Created by Phil on 12/07/2014.
 */

abstract class ToppingDecorator implements Pizza {

    protected Pizza tempPizza;

    public ToppingDecorator(Pizza newPizza) {
        tempPizza = newPizza;
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription();
    }

    @Override
    public double getCost() {
        return tempPizza.getCost();
    }
}
