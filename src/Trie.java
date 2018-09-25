/**
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class Trie {

    private Node root;


    public Trie() {
        this.root = new Node();
    }

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

    public Tuple searchTuple(Object ... pattern) {

    }

    public Tuple removeTuple(Object ... pattern) {

    }
}
