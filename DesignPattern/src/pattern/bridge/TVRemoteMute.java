package pattern.bridge;

/**
 * Created by DevMac on 18/07/2014.
 */

// Refined Abstraction

public class TVRemoteMute extends RemoteButton {

    public TVRemoteMute(EntertainmentDevice newDevice) {
        super(newDevice);
    }

    public void buttonNinePressed() {

        System.out.println("TV was Muted");

     }
}
