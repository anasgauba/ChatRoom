package TupleSpace;
import java.util.Collection;
import java.util.HashMap;

/**
 * A Node/Trie class where the trie of hashmap data structure
 * is used. It adds the tuple, search for the specific tuple
 * and remove a specific tuple from the trie of hashmap. Have a boolean
 * variable to set it true when I add the tuple to trie.
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class Node {
    private HashMap<Object, Node> children;
    private boolean isPattern;
    private Tuple tuple;

    /**
     *
     */
    public Node() {
        this.children = new HashMap<>();
    }

//    public int getChildren() {
//        return children.size();
//    }

    /**
     * Adds the tuple to trie of hashmaps. Recursively, Checks if a specific
     * Object in tuple is already in the trie, if it is, then don't add it,
     * simply get that object and store it in the node. If the Object at
     * some index is not in the trie of hashmap, then put it in the
     * trie and recursively look at the next pattern in the tuple.
     * If we reach the end of the tuple (base case), then we have the
     * pattern, so we set the isPattern to true and we have the tuple in
     * the trie now.
     * @param tuple to add in trie.
     * @param index to traverse the tree.
     */
    public void addNode(Tuple tuple, int index) {
        if (index == tuple.getSize()) {
//            System.out.println("Tuple: " + tuple);
            isPattern = true;
            this.tuple = tuple;
        }
        else if (children.containsKey(tuple.get(index))) {
//            System.out.println(tuple.get(index));
            Node child = children.get(tuple.get(index));
            child.addNode(tuple, index + 1);
        }
        else {
//            System.out.println(tuple.get(index));
            Node newNode = new Node();
            children.put(tuple.get(index), newNode);
            newNode.addNode(tuple, index + 1);
        }
    }

    /**
     * Searching for the pattern in the trie. Recursively, Checks if a specific
     * Object in tuple is already in the trie, if it is, then don't add it,
     * simply get that object and store it in the node and recursively look
     * at the next pattern in the tuple. If we have a wildcard situation at a
     * specific node, then we look at this nodes children, we ignore this
     * node and recursively look for next node (his children).
     * If we reach the end of the tuple (base case), then we check is it
     * Pattern? if it is, then we return the pattern, otherwise null.
     * @param index to traverse the trie.
     * @param pattern we're looking at in the trie.
     * @return the tuple matching the pattern we searched for.
     */
    public Tuple lookup(int index, Object... pattern) {
        Tuple match = new Tuple(pattern);
        if (index == match.getSize()) {
            if (isPattern) {
                System.out.println("Lookup: " + tuple);
                return this.tuple;
            }
            else {
                return null;
            }
        }
        else if (match.get(index) == null) {
            index++;
            Collection<Node> list = children.values();
            for (Node child : list) {
                Tuple search = child.lookup(index, pattern);
                if (search != null) {
                    return search;
                }
            }
        }
        else if (children.containsKey(match.get(index))) {
            Node node = children.get(match.get(index));
//            System.out.println(match.get(index));
            return node.lookup(index + 1, pattern);
        }
        return null;
    }

    /**
     * Searching for the pattern in the trie to Remove. Recursively, Checks
     * if a specific Object in tuple is already in the trie, if it is, then
     * don't add it, simply get that object and store it in the node and
     * recursively look at the next pattern in the tuple.
     * If we have a wildcard situation at a specific node, then we look at
     * this nodes children, we ignore this node and recursively look for next
     * node (his children). If we reach the end of the tuple (base case),
     * then we check is it Pattern? if it is, then we return the pattern,
     * otherwise null.
     * @param index to traverse the trie.
     * @param pattern we're looking at in the trie.
     * @return the tuple we want to remove.
     */
    public Tuple removeNode(int index, Object... pattern) {
        Tuple match = new Tuple(pattern);
        if (index == match.getSize()) {
            if (isPattern) {
                isPattern = false;
                System.out.println("Remove " + tuple);
                return this.tuple;
            }
        }
        else if (match.get(index) == null) {
            Collection<Node> list = children.values();
            for (Node child : list) {
                Tuple removePattern = child.removeNode(index + 1, pattern);
                if (removePattern != null) {
                    if(child.children.isEmpty() && !isPattern) {
                        children.remove(removePattern.get(index));
                    }
                    return removePattern;
                }
            }
        }
        else if (children.containsKey(match.get(index))) {
            Node node = children.get(match.get(index));
            Tuple removePattern = node.removeNode(index + 1, pattern);
            if (removePattern != null) {
                if (node.children.isEmpty() && !isPattern) {
                    children.remove(removePattern.get(index));
                }
                return removePattern;
            }
        }
        return null;
    }

}
