package pattern.facade;

/**
 * Created by Phil on 15/07/2014.
 */
public class TestBankAccount {

    public static void main(String[] args) {

        BankAccountFacade accessingBank = new BankAccountFacade(12345678, 1234);

        accessingBank.withdrawCash(50.00);
        accessingBank.withdrawCash(1200.00);
        accessingBank.depositCash(200.00);

    }

}
