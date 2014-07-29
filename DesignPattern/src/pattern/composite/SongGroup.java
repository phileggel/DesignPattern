package pattern.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by DevMac on 27/07/2014.
 */
public class SongGroup extends SongComponent {

    ArrayList songComponents = new ArrayList();


    String groupName;
    String groupDescription;

    public SongGroup(String newGroupeName, String newGroupDescription) {

        groupName = newGroupeName;
        groupDescription = newGroupDescription;

    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void add(SongComponent newSongComponent) {
        songComponents.add(newSongComponent);
    }

    public void remove(SongComponent newSongComponent) {
        songComponents.remove(newSongComponent);
    }

    public SongComponent getComponent(int componentIndex) {
        return (SongComponent) songComponents.get(componentIndex);
    }

    public void displaySongInfo() {
        System.out.println(getGroupName() + " " + getGroupDescription() + "\n");

        Iterator songIterator = songComponents.iterator();

        while (songIterator.hasNext()) {
            SongComponent songInfo = (SongComponent) songIterator.next();
            songInfo.displaySongInfo();
        }
    }
}
