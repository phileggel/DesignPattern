package pattern.command;

/**
 * Created by Phil on 13/07/2014.
 */
public class TurnTVOn implements Command {

    ElectronicDevice theDevice;

    public TurnTVOn(ElectronicDevice theDevice) {

        this.theDevice = theDevice;

    }

    @Override
    public void execute() {
        theDevice.on();
    }

    @Override
    public void undo() {
        theDevice.off();
    }
}
