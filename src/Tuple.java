/**
 * A class for tuple of any pattern (String, char, etc).
 * Have methods to get size and get the specific pattern
 * at a particular index.
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class Tuple {

    private Object[] pattern;

    /**
     * Construct a tuple obj and add it to
     * the obj array.
     * @param objs any pattern type
     */
    public Tuple(Object... objs) {
        this.pattern = objs;
    }
    public boolean isEqual(Tuple t1) {
        Object[] temp = t1.getPattern();

        if (t1.getSize() != this.getSize()) {
            return false;
        }
        else {
            for (int i = 0; i < getSize(); i++) {
                if (!pattern[i].equals(temp[i])&& temp[i] != "*") {
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * Gets any pattern at specific index in the pattern
     * array.
     * @param i index
     * @return specific pattern at specific index
     */
    public Object get(int i) {
        return pattern[i];
    }
    public Object[] getPattern() {
        return pattern;
    }

    /**
     * Gets the size of the array.
     * @return the length of obj array.
     */
    public int getSize() {
        return pattern.length;
    }

    public String toString() {
        String str = "[ ";
        for (int i = 0; i < pattern.length; i++) {
            str += pattern[i] + " ";
        }
        str += "]";
        return str;
    }
}
