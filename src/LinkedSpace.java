import java.util.LinkedList;

/**
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class LinkedSpace implements TupleSpace {
    LinkedList<Tuple> tuples;

    public LinkedSpace() {
        this.tuples = new LinkedList<>();

    }
    @Override
    public void add(Tuple tuple) {
        if (!tuples.contains(tuple)) {
            tuples.add(tuple);
        }
    }

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
