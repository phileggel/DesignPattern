/**
 * <h1>Chain of Responsability Design Pattern</h1>
 * <p>This pattern sends data to an object and if that object can't use it, it sends it to any number
 * of other objects that ma be able to use it.</p>
 * <p>Example:</p>
 * <li>Create 4 objects that can either add, substract, multiply or divide</li>
 * <li>Send 2 numbers and a command and allow these 4 objects to decide which can handle the resquested
 * calculation</li>
 *
 * @author Philippe Eggel (based on Derek Banas video tutorials) 2014/07/30
 * @version 1
 */
package pattern.chain_of_responsability;