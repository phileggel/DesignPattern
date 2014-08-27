package pattern.state;

/**
 * <h1>State Design Pattern</h1>
 * <p>Concrete State. ATMMAchine example.</p>
 *
 * @see pattern.state
 * @see pattern.state.ATMMachine
 * @see pattern.state.ATMState
 */
public class HasPin implements ATMState {

    ATMMachine atmMachine;

    public HasPin(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("You can' enter more than one card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected");
        atmMachine.setAtmState(atmMachine.getNoCardState());
    }

    @Override
    public void insertPin(int pinEnterred) {
        System.out.println("Already Entered PIN");
    }

    @Override
    public void requestCash(int cashtoWithdraw) {

        if (cashtoWithdraw > atmMachine.cashInMachine) {
            System.out.println("Don't Have that cash");
            System.out.println("Card Ejected");
            atmMachine.setAtmState(atmMachine.getNoCardState());
        } else {
            System.out.println(cashtoWithdraw + " is provided by the Machine");
            atmMachine.setCashInMachine(atmMachine.cashInMachine - cashtoWithdraw);
            System.out.println("Card Ejected");
            atmMachine.setAtmState(atmMachine.getNoCardState());

            if (atmMachine.cashInMachine <= 0) {
                atmMachine.setAtmState(atmMachine.getNoCashState());
            }
        }
    }
}
