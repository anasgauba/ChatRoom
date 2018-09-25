import java.util.HashMap;

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
            this.tuple = tuple;
        }
        else if (children.containsKey(tuple.get(index))) {
            Node child = children.get(tuple.get(index));
            child.addNode(tuple, index + 1);
        }
        else {
            Node newNode = new Node();
            children.put(tuple.get(index), newNode);
            newNode.addNode(tuple, index + 1);
        }
//        addNode(tuple, index + 1);
    }

    public Node getChildren(Object obj) {
        return this.children.get(obj);
    }

    public Node setChildren(Object obj) {
        return this.children.put(obj, new Node());
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
