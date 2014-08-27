package pattern.memento;

import java.util.ArrayList;

/**
 * Created by DevMac on 06/08/2014.
 */
public class Caretaker {

    ArrayList<Memento> savedArticles = new ArrayList<Memento>();

    public void addMemento(Memento m) { savedArticles.add(m); }

    public Memento getMemento(int index) { return savedArticles.get(index); }

}
