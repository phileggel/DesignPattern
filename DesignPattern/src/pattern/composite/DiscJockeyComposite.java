package pattern.composite;

import pattern.iterator.DiscJockey;

/**
 * Created by DevMac on 27/07/2014.
 */
public class DiscJockeyComposite {

    SongComponent songList;

    public DiscJockeyComposite(SongComponent newSongList) {

        songList = newSongList;

    }

    public void getSongList() {

        songList.displaySongInfo();
    }

}
