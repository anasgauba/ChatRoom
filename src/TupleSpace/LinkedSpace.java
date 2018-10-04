package TupleSpace;
import java.util.LinkedList;

/**
 * Naive implementation of tupleSpace. Adds, remove, and search
 * for tuples. All size tuples are shoved into linked list.
 *
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class LinkedSpace implements TupleSpace {
    private LinkedList<Tuple> tuples;

    /**
     * Construct a tupleSpace using a linkedlist data
     * structure.
     */
    public LinkedSpace() {
        this.tuples = new LinkedList<>();

    }

    /**
     * Adding n size tuples to the linkedlist. Making sure to
     * not add duplicates tuples in the list.
     * @param tuple to add
     */
    @Override
    public void add(Tuple tuple) {
        if (!tuples.contains(tuple)) {
            tuples.add(tuple);
        }
    }

    /**
     * Searching the specific tuple in the list with the given
     * pattern and returning it. If we couldn't find the pattern
     * in the list, then we return null. Wilcards are handle in the isEqual
     * method in the Tuple class.
     * @param pattern to search for.
     * @return the tuple that we searched for.
     */
    @Override
    public Tuple search(Object... pattern) {
        Tuple match = new Tuple(pattern);
        for (int i = 0; i < tuples.size(); i++) {
            if (tuples.get(i).isEqual(match)) {
                System.out.println(tuples.get(i));
                return tuples.get(i);
            }
        }
        return null;
    }

    /**
     * Removing the specific tuple in the list with the given pattern
     * and returning the remove tuple. Wilcards are handle in the isEqual
     * method in the Tuple class. If we found one the tuple matched
     * with the pattern then we simply remove that from the list.
     * @param pattern to remove.
     * @return the removed tuple from the list.
     */
    @Override
    public Tuple remove(Object... pattern) {
        Tuple match = new Tuple(pattern);
        for (int i = 0; i < tuples.size(); i++) {
            if (tuples.get(i).isEqual(match)) {
                System.out.println(tuples.remove(i));
                return tuples.remove(i);
            }
        }
        return null;
    }
}
