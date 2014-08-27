package pattern.chain_of_responsability;

/**
 * <h1>Chain Of Responsability Design Pattern</h1>
 * <p>interface principale pour lier les objets entre eux.</p>
 *
 * @see pattern.chain_of_responsability
 * @see pattern.chain_of_responsability.Numbers
 */
public interface Chain {

    public void setNextChain(Chain nextChain);
    public void calculate(Numbers request);

}
