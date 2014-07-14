package pattern.observer;

/**
 * Created by Phil on 01/07/2014.
 */
public interface Subject {

    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObserver();

}
