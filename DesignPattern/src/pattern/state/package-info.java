/**
 * <h1>State Design Pattern</h1>
 * <p>Allows an object to alter its behavior when its internal state changes.
 * The object will appear to change its class. There are 3 components : </p>
 *<li>Context (Account) : Maintains an instance of a ConcreteState subclass that defines the current state.</li>
 *<li>State : Defines an interface for encapsulating the behavior associated with a particular state of the context.</li>
 *<li>Concrete State : Each subclass implements a behavior associated with a state of Context</li>
 *
 * @author Philippe Eggel (based on Derek Banas video tutorials) 2014/07/30
 * @version 1
 */
package pattern.state;