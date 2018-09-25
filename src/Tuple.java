/**
 * A class for tuple of any object (String, char, etc).
 * Have methods to get size and get the specific object
 * at a particular index.
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class Tuple {

    private Object[] object;

    /**
     * Construct a tuple obj and add it to
     * the obj array.
     * @param objs any object type
     */
    public Tuple(Object... objs) {
        this.object = objs;
    }

    /**
     * Gets any object at specific index in the object
     * array.
     * @param i index
     * @return specific object at specific index
     */
    public Object get(int i) {
        return object[i];
    }

    /**
     * Gets the size of the array.
     * @return the length of obj array.
     */
    public int getSize() {
        return object.length;
    }

    public String toString() {
        String str = "[ ";
        for (int i = 0; i < object.length; i++) {
            str += object[i] + " ";
        }
        str += "]";
        return str;
    }
}
