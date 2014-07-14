package pattern.command;

/**
 * Created by Phil on 13/07/2014.
 */
public class TVRemote {

    public static ElectronicDevice getDevice() {
        return new Television();
    }

}
