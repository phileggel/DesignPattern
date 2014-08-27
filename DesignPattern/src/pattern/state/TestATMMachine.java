package pattern.state;

import pattern.proxy.ATMProxy;
import pattern.proxy.GetATMData;

/**
 * <h1>State Design Pattern & Proxy Design Pattern</h1>
 * <p>Class de demonstration pour les pattern.state et pattern.proxy</p>
 *
 * @see pattern.state
 * @see pattern.state.ATMMachine
 * @see pattern.state.ATMState
 * @see pattern.proxy
 * @see pattern.proxy.ATMProxy
 * @see pattern.proxy.GetATMData
 */
public class TestATMMachine {

    public static void main(String[] args) {

        ATMMachine atmMachine = new ATMMachine();

        atmMachine.insertCard();
        atmMachine.ejectCard();

        atmMachine.insertCard();
        atmMachine.insertPin(1234);
        atmMachine.requestCash(2000);

        atmMachine.insertCard();
        atmMachine.insertPin(2000);

        // pattern.proxy
        GetATMData realATMMachine = new ATMMachine();
        GetATMData atmProxy = new ATMProxy();

        System.out.println("\nCurrent ATM State " + atmProxy.getATMData());
        System.out.println("\nCash in ATM Machine " + atmProxy.getCashInMachine());
        // atmProxy.setCashInMachine -> not available
        // realATMMachine.setCashInMachine -> not available too

    }

}
