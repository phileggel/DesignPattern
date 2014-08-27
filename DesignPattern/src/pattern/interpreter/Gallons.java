package pattern.interpreter;

/**
 * <h1>Interpreter Design Pattern</h1>
 * <p>A Terminal (Concrete Expression)</p>
 *
 * @author Philippe Eggel (based on Derek Banas video tutorials) 01/08/2014
 * @version 1
 *
 * @see pattern.interpreter
 * @see ConversionContext
 * @see Expression
 */
public class Gallons extends Expression {

    @Override
    public String gallons(double quantity) {
        return Double.toString(quantity);
    }

    @Override
    public String quarts(double quantity) {
        return Double.toString(quantity * 4);
    }

    @Override
    public String pints(double quantity) {
        return Double.toString(quantity * 8);
    }

    @Override
    public String cups(double quantity) {
        return Double.toString(quantity * 16);
    }

    @Override
    public String tablespoons(double quantity) {
        return Double.toString(quantity * 256);
    }
}
