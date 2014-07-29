package pattern.bridge;

import pattern.command.TVRemote;

/**
 * Created by DevMac on 18/07/2014.
 */
public class TVRemotePause extends RemoteButton {

    public TVRemotePause(EntertainmentDevice newDevice) {
        super(newDevice);
    }

    public void buttonNinePressed() {

        System.out.println("TV was Paused");

    }
}
