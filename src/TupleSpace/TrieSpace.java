package TupleSpace;
/**
 * A TupleSpace class which uses trie of hashmap
 * data structure to add tuples, search for tuples,
 * and remove the specified tuple. This class calls methods
 * from Node class and that's where the logic is.
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class TrieSpace implements TupleSpace{

    private Node root;

    /**
     * Construct a new node in the tree.
     */
    public TrieSpace() {
        this.root = new Node();
    }

//    public int getMapSize() {
//        return root.getChildren();
//    }

    /**
     * Calls helper function in Node class
     * to add the node to the tree. Always starting
     * at the index 0 so we can add tuple from the beginning.
     * @param tuple to add to tupleSpace.
     */
    public void add(Tuple tuple) {
        root.addNode(tuple, 0);
    }

    /**
     * Calls helper function in Node class to search
     * for the specific pattern in the tree. Always starting
     * at the index 0 so we can search tuple from the beginning.
     * @param pattern to search for.
     * @return tuple found with the pattern in the tupleSpace.
     */
    public Tuple search(Object ... pattern) {
        return root.lookup(0, pattern);
    }

    /**
     * Calls helper function in Node class to remove the
     * specific pattern from the tree. Always starting
     * at the index 0 so we can remove tuple from the beginning.
     * @param pattern to remove from the tupleSpace.
     * @return tuple found with the pattern in the tupleSpace.
     */
    public Tuple remove(Object ... pattern) {
        return root.removeNode(0, pattern);
    }
}
