package pattern.bridge;

/**
 * Created by DevMac on 18/07/2014.
 */
public class DVDRemote extends RemoteButton {

    private boolean play = true;

    public DVDRemote(EntertainmentDevice newDevice) {
        super(newDevice);
    }

    public void buttonNinePressed() {

        play = !play;

        System.out.println("DVD is Playing: " + play);

    }
}


