package pattern.observer;

/**
 * Created by Phil on 01/07/2014.
 */
public class GrabStocks {

    public static void main(String[] args) {

        StockGrabber stockGrabber = new StockGrabber();

        StockObserver observer1 = new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(197.00);
        stockGrabber.setAaplPrice(55.00);
        stockGrabber.setGoogPrice(24.00);

        StockObserver observer2 = new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(197.00);
        stockGrabber.setAaplPrice(677.60);
        stockGrabber.setGoogPrice(676.40);

        stockGrabber.unregister(observer1);

        Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
        Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 677.60);
        Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 676.40);

        new Thread(getIBM).start();
        new Thread(getAAPL).start();
        new Thread(getGOOG).start();

    }

}
