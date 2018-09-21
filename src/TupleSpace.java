import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class TupleSpace {
    private Hashtable<Object, ArrayList<Tuple>> tuples;
    private Tuple tuple = new Tuple();

    public void add(Tuple tuple) {
        ArrayList<Tuple> vals = tuples.get(9);
        vals.add(0, tuple);
    }

    public Tuple remove() {
        return tuple;
    }

    public Tuple read() {
        return tuple;
    }
}
