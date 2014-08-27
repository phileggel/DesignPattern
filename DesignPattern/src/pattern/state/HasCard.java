package pattern.state;

/**
 * <h1>State Design Pattern</h1>
 * <p>Concrete State. ATMMAchine example.</p>
 *
 * @see pattern.state
 * @see pattern.state.ATMMachine
 * @see pattern.state.ATMState
 */
public class HasCard implements ATMState{

    ATMMachine atmMachine;

    public HasCard(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    // Les méthodes concrêtes sont implantées et vont permettre
    // de manipuler l'ATMMachine et de changer l'état de celle-ci si nécessaire.
    @Override
    public void insertCard() {
        System.out.println("You can't enter more than one card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected");
        atmMachine.setAtmState(atmMachine.getNoCardState());
    }

    @Override
    public void insertPin(int pinEnterred) {
        if (pinEnterred == 1234) {
            System.out.println("Correct PIN");
            atmMachine.correctPinEntered = true;
            atmMachine.setAtmState(atmMachine.getHasPin());
        } else {
            System.out.println("Wrong PIN");
            atmMachine.correctPinEntered = false;
            System.out.println("Card Ejected");
            atmMachine.setAtmState(atmMachine.getNoCardState());
        }
    }

    @Override
    public void requestCash(int cashtoWithdraw) {
        System.out.println("Enter PIN first");
    }
}
