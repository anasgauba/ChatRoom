import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class Node {
//    Object myObj;
    private HashMap<Object, Node> children;
    boolean isPattern;
    Tuple tuple;
//    LinkedList<Node> root;

    public Node() {
        this.children = new HashMap<>();
    }

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
            System.out.println(match.get(index));
            return node.lookup(index + 1, pattern);
        }
        return null;
    }

    public Tuple removeNode(int index, Object... pattern) {
        Tuple match = new Tuple(pattern);
        if (index == match.getSize()) {
            if (isPattern) {

            }
            return this.tuple;
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
            return node.lookup(index + 1, pattern);

        }
        return null;
    }

    public boolean isPattern() {
        return isPattern;
    }
    public void setPattern(boolean pattern) {
        this.isPattern = pattern;
    }

//    public void insert(Tuple tuple) {

//        Node current = new Node();
//        Class objType = object.getClass();
//        if (children.containsKey(object)) {
//            current = children.get(object);
//        }
//        else {
//            current = new Node();
//        }
//        children.put(objType, current);
//    }

    public static void main(String[] args) {
//        Node node = new Node();
//        String str = "Name";
//        node.insert(str);
//        System.out.println();

    }
}
