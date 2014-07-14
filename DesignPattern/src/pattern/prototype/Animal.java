package pattern.prototype;

/**
 * Created by Phil on 05/07/2014.
 */

// By making this class cloneable you are telling Java
// that it is ok to copy instances of this class
// These instance copies have different results when
// System.identityHashCode(System.identityHashCode(bike))
// is called

public interface Animal extends Cloneable {

    public Animal makeCopy();

}
