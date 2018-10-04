package TupleSpace;
/**
 * An interface for implementing two different
 * data structures for TupleSpace. One is naive (slow) implementation
 * of tupleSpace and the other is faster implementation of tupleSpace.
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public interface TupleSpace {
    public void add(Tuple tuple);
    public Tuple search(Object ... pattern);
    public Tuple remove(Object ... pattern);
}
