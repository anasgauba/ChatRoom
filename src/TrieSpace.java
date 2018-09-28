import java.util.HashMap;

/**
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class TrieSpace {

    private Node root;


    public TrieSpace() {
        this.root = new Node();
    }

//    public int getMapSize() {
//        return root.getChildren();
//    }
    public void add(Tuple tuple) {
        root.addNode(tuple, 0);
//        Node head = root;
//        if (head.isPattern()) {
//            head.setPattern(true);
//            return;
//        }
//        else if () {
//
//        }

//        for (int i = 0; i < tuple.getSize(); i++) {
//            if (head.getChildren(tuple.get(i)) == null) {
//                head.setChildren(tuple.get(i));
//            }
//            head = head.getChildren(tuple.get(i));
//        }
//        head.setPattern(true);
    }

    public Tuple search(Object ... pattern) {
        return root.lookup(0, pattern);
    }

    public Tuple remove(Object ... pattern) {
        return root.removeNode(0, pattern);
    }
}
