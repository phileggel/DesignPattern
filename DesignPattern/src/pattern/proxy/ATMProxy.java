package pattern.proxy;

import pattern.state.ATMMachine;
import pattern.state.ATMState;

/**
 * <p>Implante l'interface GetATMData.
 * Dans le cadre de l'exemple, on utilise l'ATMMachine définie dans l'exemple pattern.state.
 * La machine est créée directement lors des appels. On pourrait sinon éventuellement la faire persister.</p>
 *
 * @see pattern.proxy
 * @see pattern.proxy.GetATMData
 * @see pattern.state.ATMState
 * @see pattern.state.ATMMachine
 */
public class ATMProxy implements GetATMData {

    @Override
    public ATMState getATMData() {
        ATMMachine realATMMachine = new ATMMachine();
        return realATMMachine.getATMData();
    }

    @Override
    public int getCashInMachine() {
        ATMMachine realATMMachine = new ATMMachine();
        return realATMMachine.getCashInMachine();
    }
}
