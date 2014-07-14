package pattern.observer;

/**
 * Created by Phil on 01/07/2014.
 */
public class StockObserver implements Observer {

    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    private static int observerIdTracker = 0;
    private int observerId;
    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber) {

        this.stockGrabber = stockGrabber;
        this.observerId = ++observerIdTracker;
        System.out.println("New Observer " + this.observerId);
        stockGrabber.register(this);
    }


    @Override
    public void update(double ibmPrice, double aaplPrice, double googPrice) {

        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;

        printThePrice();
    }

    private void printThePrice() {

        System.out.println(observerId + "\nIBM:" + ibmPrice
            + "\nAPPLE:" + aaplPrice
            + "\nGOOGLE:" + googPrice + "\n");

    }

}
