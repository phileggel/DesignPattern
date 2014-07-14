package pattern.decorator;

/**
 * Created by Phil on 12/07/2014.
 */
public class PlainPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Thin dough";
    }

    @Override
    public double getCost() {
        return 4.00;
    }
}
