package pattern.interpreter;

/**
 * <h1>Interpreter Design Pattern</h1>
 * <p>Expression</p>
 *
 * @author Philippe Eggel (based on Derek Banas video tutorials) 01/08/2014
 * @version 1
 *
 * @see pattern.interpreter
 * @see ConversionContext
 */
public abstract class Expression {

    public abstract String gallons(double quantity);
    public abstract String quarts(double quantity);
    public abstract String pints(double quantity);
    public abstract String cups(double quantity);
    public abstract String tablespoons(double quantity);

}
