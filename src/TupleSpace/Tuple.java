package TupleSpace;
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

    /**
     * Compares the two tuples and checks for wildcards as
     * well. This method is helper method for linked list tuple
     * space implementation. It checks the two tuples for the
     * same pattern and also checks if there are wildcards, if there
     * are, then it ignores them and simply search the next pattern
     * in the tuple and returns true if the pattern matches with the
     * given tuple.
     * @param t1 tuple to compare with.
     * @return true/false based on the pattern match.
     */
    public boolean isEqual(Tuple t1) {
        Object[] temp = t1.getPattern();

        if (t1.getSize() != this.getSize()) {
            return false;
        }
        else {
            for (int i = 0; i < getSize(); i++) {
                if (!pattern[i].equals(temp[i])&& temp[i] != null) {
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

    /**
     * Gets the whole tuple pattern.
     * @return all the patterns in the tuple.
     */
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

    /**
     *
     * @return string representation of the tuple.
     */
    public String toString() {
        String str = "[ ";
        for (int i = 0; i < pattern.length; i++) {
            str += pattern[i] + " ";
        }
        str += "]";
        return str;
    }
}
