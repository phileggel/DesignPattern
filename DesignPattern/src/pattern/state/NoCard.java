package pattern.state;

/**
 * <h1>State Design Pattern</h1>
 * <p>Concrete State. ATMMAchine example.</p>
 *
 * @see pattern.state
 * @see pattern.state.ATMMachine
 * @see pattern.state.ATMState
 */
public class NoCard implements ATMState {

    ATMMachine atmMachine;

    public NoCard(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Card entered");
        atmMachine.setAtmState(atmMachine.getYesCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("Enter a card first");
    }

    @Override
    public void insertPin(int pinEnterred) {
        System.out.println("Enter a card first");
    }

    @Override
    public void requestCash(int cashtoWithdraw) {
        System.out.println("Enter a card first");
    }
}
