package pattern.chain_of_responsability;

/**
 * <h1>Chain Of Responsability Design Pattern</h1>
 *
 * @see pattern.chain_of_responsability.Chain
 * @see pattern.chain_of_responsability.Numbers
 */
public class MultNumbers implements Chain {
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if (request.getCalculationWanted() == "mult") {
            System.out.println(request.getNumber1() + " * " + request.getNumber2() + " = "
                    + (request.getNumber1() * request.getNumber2()));
        } else {
            nextInChain.calculate(request);
        }
    }
}
