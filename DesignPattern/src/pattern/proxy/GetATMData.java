package pattern.proxy;

import pattern.state.ATMState;

/**
 * <p>Interface commune Proxy & ATMMachine.
 * Dans le cadre de l'exemple, on utilise l'ATMMachine définie dans l'exemple pattern.state.</p>
 *
 * @see pattern.proxy
 * @see pattern.proxy.ATMProxy
 * @see pattern.state.ATMState
 * @see pattern.state.ATMMachine
 */
public interface GetATMData {

    public ATMState getATMData();
    public int getCashInMachine();

}
