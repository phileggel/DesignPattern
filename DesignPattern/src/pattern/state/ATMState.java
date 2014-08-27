package pattern.state;

/**
 * State of the machine.
 *
 * @see pattern.state
 * @see pattern.state.ATMMachine
 *
 */
public interface ATMState {

    void insertCard();
    void ejectCard();
    void insertPin(int pinEnterred);
    void requestCash(int cashtoWithdraw);

}
