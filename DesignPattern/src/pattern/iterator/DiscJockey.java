package pattern.iterator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by DevMac on 22/07/2014.
 */
public class DiscJockey {

    SongsOfThe70s songs70s;
    SongsOfThe80s songs80s;
    SongsOfThe90s songs90s;

    SongIterator iter70sSongs;
    SongIterator iter80sSongs;
    SongIterator iter90sSongs;

    // Pattern iterator
    public DiscJockey(SongIterator iter70sSongs,
                      SongIterator iter80sSongs,
                      SongIterator iter90sSongs) {

        this.iter70sSongs = iter70sSongs;
        this.iter80sSongs = iter80sSongs;
        this.iter90sSongs = iter90sSongs;

        System.out.println("Pattern Iterator -----------------");

    }

    // no Pattern iterator
    public DiscJockey(SongsOfThe70s newSongs70s,
                      SongsOfThe80s newSongs80s,
                      SongsOfThe90s newSongs90s) {

        songs70s = newSongs70s;
        songs80s = newSongs80s;
        songs90s = newSongs90s;

    }

    public void showTheSongs() {
        ArrayList aL70sSongs = songs70s.getBestSongs();
        System.out.println("Songs of the 70s\n");
        for (int i = 0; i < aL70sSongs.size(); i++) {
            SongInfo bestSongs = (SongInfo) aL70sSongs.get(i);

            System.out.println(bestSongs.getSongName());
            System.out.println(bestSongs.getBandName());
            System.out.println(bestSongs.getYearReleased() + "\n");

        }

        SongInfo[] array80sSongs = songs80s.getBestSongs();

        System.out.println("Songs of the 80s\n");

        for(int j=0; j < array80sSongs.length; j++){

            SongInfo bestSongs = array80sSongs[j];

            System.out.println(bestSongs.getSongName());
            System.out.println(bestSongs.getBandName());
            System.out.println(bestSongs.getYearReleased() + "\n");

        }

        Hashtable<Integer, SongInfo> ht90sSongs = songs90s.getBestSongs();

        System.out.println("Songs of the 90s\n");

        for(Enumeration<Integer> e = ht90sSongs.keys(); e.hasMoreElements();){

            SongInfo bestSongs = ht90sSongs.get(e.nextElement());

            System.out.println(bestSongs.getSongName());
            System.out.println(bestSongs.getBandName());
            System.out.println(bestSongs.getYearReleased() + "\n");

        }


    }

    public void showTheSongs2() {

        Iterator songs70s = iter70sSongs.createIterator();
        Iterator songs80s = iter80sSongs.createIterator();
        Iterator songs90s = iter90sSongs.createIterator();

        System.out.println("Songs of the 70s\n");
        printTheSongs(songs70s);

        System.out.println("Songs of the 80s\n");
        printTheSongs(songs80s);

        System.out.println("Songs of the 90s\n");
        printTheSongs(songs90s);

    }

    public void printTheSongs(Iterator iterator) {

        while(iterator.hasNext()) {

            SongInfo songInfo = (SongInfo) iterator.next();

            System.out.println(songInfo.getSongName());
            System.out.println(songInfo.getBandName());
            System.out.println(songInfo.getYearReleased() + "\n");
        }

    }

}
