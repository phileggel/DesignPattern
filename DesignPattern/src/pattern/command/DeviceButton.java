package pattern.command;

/**
 * Created by Phil on 13/07/2014.
 */
public class DeviceButton {

    Command theCommand;

    public DeviceButton(Command newCommand) {
        theCommand = newCommand;
    }

    public void press() {
        theCommand.execute();
    }

    public void pressUndo() {
        theCommand.undo();
    }

}
