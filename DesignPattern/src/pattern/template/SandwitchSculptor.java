package pattern.template;

/**
 * Created by DevMac on 19/07/2014.
 */
public class SandwitchSculptor {

    public static void main(String[] args) {

        ItalianHoagie cust12Hoagie = new ItalianHoagie();

        cust12Hoagie.makeSandwich();

        System.out.println();

        VeggieHoagie cust13Hoagie = new VeggieHoagie();

        cust13Hoagie.makeSandwich();

    }

}
