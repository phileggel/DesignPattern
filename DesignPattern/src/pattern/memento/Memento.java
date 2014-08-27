package pattern.memento;

/**
 * Created by DevMac on 06/08/2014.
 */
public class Memento {

    private String article;

    public Memento(String articleSave) { article = articleSave; }

    public String getSavedArticle() { return article; }

}
