package pattern.facade;

/**
 * Created by Phil on 15/07/2014.
 */
public class AccountNumberCheck {

    private int accountNumber = 12345678;

    public int getAccountNumber() { return accountNumber; }

    public boolean accountActive(int accNumToCheck) {

        if (accNumToCheck == getAccountNumber()) {
            return true;
        } else {
            return false;
        }
    }
}
