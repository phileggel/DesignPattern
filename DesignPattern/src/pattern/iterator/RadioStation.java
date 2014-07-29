package pattern.iterator;

/**
 * Created by DevMac on 22/07/2014.
 */
public class RadioStation {

    public static void main(String[] args) {

        SongsOfThe70s songs70s = new SongsOfThe70s();   // arraylist
        SongsOfThe80s songs80s = new SongsOfThe80s();   // array
        SongsOfThe90s songs90s = new SongsOfThe90s();   // hashtable

        DiscJockey madMike = new DiscJockey(songs70s, songs80s, songs90s);
        madMike.showTheSongs();         // no pattern iterator

        DiscJockey madMike2 = new DiscJockey(
                (SongIterator) songs70s,
                (SongIterator) songs80s,
                (SongIterator) songs90s);
        madMike2.showTheSongs2();           // pattern iterator;
    }





}
