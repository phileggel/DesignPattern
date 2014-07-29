package pattern.composite;

/**
 * Created by DevMac on 27/07/2014.
 */
public class SongListGenerator {

    public static void main(String[] args) {

        // ce pattern permet de traiter un arbre avec plusieurs types d'objets
        // des objets "dossiers" et des feuilles

        SongComponent industrialMusic = new SongGroup("Industrial", "musique industrielle");
        SongComponent heavyMetalMusic = new SongGroup("Heavy Metal", "hard rock");
        SongComponent dubstepMusic = new SongGroup("Dubstep", "connait pas");

        SongComponent everySong = new SongGroup("Song List", "Every Song available");

        everySong.add(industrialMusic);
        everySong.add(heavyMetalMusic);
        industrialMusic.add(new Song("Head like a hole", "nin", 1990));
        industrialMusic.add(new Song("headhunter", "Front 242", 1988));
        industrialMusic.add(dubstepMusic);

        // etc.

    }

}
