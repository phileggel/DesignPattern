package pattern.chain_of_responsability;

/**
 * <h1>Chain of Responsability Design Pattern</h1>
 * <p>Méthode de test de l'exemple</p>
 *
 * @author Philippe Eggel (based on Derek Banas video tutorials) 2014/07/30
 * @version 1
 *
 * @see pattern.chain_of_responsability
 * @see pattern.chain_of_responsability.Chain
 * @see pattern.chain_of_responsability.AddNumbers
 * @see pattern.chain_of_responsability.SubstractNumbers
 * @see pattern.chain_of_responsability.MultNumbers
 * @see pattern.chain_of_responsability.DivideNumbers
 */
public class TextCalcChain {

    public static void main(String[] args) {

        Chain chainCacl1 = new AddNumbers();
        Chain chainCacl2 = new SubstractNumbers();
        Chain chainCacl3 = new MultNumbers();
        Chain chainCacl4 = new DivideNumbers();

        chainCacl1.setNextChain(chainCacl2);
        chainCacl2.setNextChain(chainCacl3);
        chainCacl3.setNextChain(chainCacl4);

        Numbers request = new Numbers(4, 2, "add");
        chainCacl1.calculate(request);

        Numbers request2 = new Numbers(4, 2, "div");
        chainCacl1.calculate(request2);

    }

}
