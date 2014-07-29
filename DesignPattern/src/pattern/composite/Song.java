package pattern.composite;

/**
 * Created by DevMac on 27/07/2014.
 */
public class Song extends SongComponent {


    String songName;
    String bandName;
    int releaseYear;

    public Song(String newSongName, String newBandName, int newYearReleased) {

        songName = newSongName;
        bandName = newBandName;
        releaseYear = newYearReleased;

    }

    public String getSongName() {
        return songName;
    }

    public String getBandName() {
        return bandName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void displayInfo() {
        System.out.println(getSongName() + "was recorded by " + getBandName() + " in " + getReleaseYear());
    }

}
