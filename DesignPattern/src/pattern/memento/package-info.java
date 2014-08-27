/**
 * <h1>Memento Design Pattern</h1>
 * <p>A way to store previous states of an object easily</p>
 * <li>Memento: The basic object that is stored in different states</li>
 * <li>Originator: Sets and Gets values from the currently targeted Memento.
 * Creates new Mementos and assigns current values to them.</li>
 * <li>Caretaker: Holds an ArrayList that contains all previous versions of
 * the Memento. It can store and retrieve stored Mementos</li>
 *
 * @author Philippe Eggel (based on Derek Banas video tutorials) 06/08/2014
 * @version 1
 */
package pattern.memento;