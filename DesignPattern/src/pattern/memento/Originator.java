package pattern.memento;

/**
 * Created by DevMac on 06/08/2014.
 */
public class Originator {

    private String article;

    public void set(String newArticle) {
        System.out.println("From originator : Current Version of Article\n"
        + newArticle + "\n");

        article = newArticle;
    }

    public Memento storeInMemento() {
        System.out.println("From originator : Saving to Memento");

        return new Memento(article);
    }

    public String restoreFromMemento(Memento memento) {
        article = memento.getSavedArticle();
        System.out.println("From originator : Previous Article Saved in Memento\n" + article + "\n");
        return article;
    }
}
