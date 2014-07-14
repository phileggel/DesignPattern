package pattern.decorator;

/**
 * Created by Phil on 12/07/2014.
 */
public class PizzaMaker {

    public static void main(String[] args) {

        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));

        System.out.println("Ingredients: " + basicPizza.getDescription());
        System.out.println("Cost:" + basicPizza.getCost());
    }

}
