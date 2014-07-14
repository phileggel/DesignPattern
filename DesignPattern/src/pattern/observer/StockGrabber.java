package pattern.observer;

import java.util.ArrayList;

/**
 * Created by Phil on 01/07/2014.
 */
public class StockGrabber implements Subject  {

    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    public StockGrabber() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        int observerIndex = observers.indexOf(observer);
        System.out.println("Observer " + observerIndex + " deleted");
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {

        for(Observer observer : observers) {
            observer.update(ibmPrice, aaplPrice, googPrice);
        }

    }

    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObserver();
    }

    public void setAaplPrice(double aaplPrice) {
        this.aaplPrice = aaplPrice;
        notifyObserver();
    }

    public void setGoogPrice(double googPrice) {
        this.googPrice = googPrice;
        notifyObserver();
    }
}
