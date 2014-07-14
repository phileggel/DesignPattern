package pattern.command;

/**
 * Created by Phil on 13/07/2014.
 */
public class TurnTVDown implements Command {

    ElectronicDevice theDevice;

    public TurnTVDown(ElectronicDevice theDevice) {

        this.theDevice = theDevice;

    }

    @Override
    public void execute() {

        theDevice.volumeDown();

    }

    @Override
    public void undo() {
        theDevice.volumeUp();
    }
}
