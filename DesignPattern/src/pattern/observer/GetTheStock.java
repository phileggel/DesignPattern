package pattern.observer;

import java.text.DecimalFormat;

/**
 * Created by Phil on 01/07/2014.
 */
public class GetTheStock implements Runnable {

    private int startTime;
    private String stock;
    private double price;

    private Subject stockGrabber;

    public GetTheStock(Subject stockGrabber,
                       int startTime,
                       String stock,
                       double price) {

        this.stockGrabber = stockGrabber;
        this.startTime = startTime;
        this.stock = stock;
        this.price = price;

    }

    @Override
    public void run() {

        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            double randNum = (Math.random() * (.06)) - .03;
            DecimalFormat df = new DecimalFormat("####.##");

            System.out.println(randNum + " " + price + " "
                    + (randNum + price));
            price = Double.valueOf(df.format(price + randNum));

            if (stock == "IBM") {
                ((StockGrabber)stockGrabber).setIbmPrice(price);
            }
            if (stock == "AAPL") {
                ((StockGrabber)stockGrabber).setAaplPrice(price);
            }
            if (stock == "GOOG") {
                ((StockGrabber)stockGrabber).setGoogPrice(price);
            }

            System.out.println(stock + ": " + df.format(price + randNum)
                + " " + df.format(randNum));

        }
    }
}
