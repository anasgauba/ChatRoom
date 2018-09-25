import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class TupleSpace {
    Trie trie;
//    HashMap<Integer, HashMap<Object, LinkedList<Tuple>>> space;
//    private Hashtable<Object, Trie> tuples;

    public void add(Tuple tuple) {
//        if (space.containsKey(tuple.getSize()) == false) {
//            space.get(tuple.getSize()).get(tuple.get(0));
//        }
        this.trie.addNode(tuple);
    }

    public Tuple read(Object... pattern) {
        return trie.searchTuple(pattern);
    }

    public Tuple remove(Object ... pattern) {
        return trie.removeTuple(pattern);
    }
}
