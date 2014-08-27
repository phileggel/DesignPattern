/**
 * <h1>Interpreter Design Pattern</h1>
 * <p>This pattern is normally ignored. It is almost ignored.
 * It is used to convert a representation of data into another.</p>
 * <p>This is a version from Derek Banas (not GoF), as he found it
 * extremely useful if combined with Java Reflexion</p>
 * <li>The Context contains the information that will be interpreted</li>
 * <li>The Expression is an abstract class that defines all the methods needed to perform the different conversions</li>
 * <li>The Terminal (or Concrete Expressions) provide specific conversions on different types of Data</li>
 *
 * @author Philippe Eggel (based on Derek Banas video tutorials) 01/08/2014
 * @version 1
 */
package pattern.interpreter;