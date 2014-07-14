package pattern.decorator;

/**
 * Created by Phil on 12/07/2014.
 */
public class Mozzarella extends ToppingDecorator {

    public Mozzarella(Pizza newPizza) {
        super(newPizza);

        System.out.println("Adding Dough");
        System.out.println("Adding Moz");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mozzarella";
    }

    @Override
    public double getCost() {
        return super.getCost() + .50;
    }
}
