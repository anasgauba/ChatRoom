/**
 * Stress testing class to test the tuple space.
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        Tuple tuple = null;

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                tuple = new Tuple("anas " + i, 2, 5);
                trie.add(tuple);
            }
            else if (i % 3 == 0) {
                tuple = new Tuple('c', 2.54, 2.678884224, "pet " + i);
                trie.add(tuple);
            }
            else if (i % 5 == 0) {
                tuple = new Tuple('d', 3.1458, 1.98643320, 'm', "dog " + i);
                trie.add(tuple);
            }
        }
    }
}
