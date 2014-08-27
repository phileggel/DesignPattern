package pattern.chain_of_responsability;

/**
 * <h1>Chain Of Responsability Design Pattern</h1>
 *
 * @see pattern.chain_of_responsability.Chain
 * @see pattern.chain_of_responsability.Numbers
 */
public class DivideNumbers implements Chain {
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if (request.getCalculationWanted() == "div") {
            System.out.println(request.getNumber1() + " / " + request.getNumber2() + " = "
                    + (request.getNumber1() / request.getNumber2()));
        } else {
            // fin de la boucle de la chaine
            System.out.println("Only Works for add, sub, mult and div");
        }
    }
}
