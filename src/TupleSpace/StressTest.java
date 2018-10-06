package TupleSpace;

/**
 * Stress testing class to test the tuple space. On line 10, can change from
 * elegant version to naive one. Its adding 100000 tuples to the tupleSpace,
 * searching/removing 60000 tuples together. On avg, it takes about a min for
 * the elegant version, and linkedList version takes forever (should reduce
 * the number of tuples to add/search/remove to 10000 to compare with elegant
 * implementation, clearly elegant implementation wins- the linkedList
 * version for adding/searching/removing 7000 tuples takes 216.48 seconds,
 * more than 3 mins (3.6 mins)).
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class StressTest {
    public static void main(String[] args) {
        TrieSpace trie = new TrieSpace();
        Tuple tuple;
        long time = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            if (i % 2 == 0) {
//                System.out.println("i mod 2 " + i);
                tuple = new Tuple("anas " + i, 2);
                trie.add(tuple);
            }
            else if (i % 3 == 0) {
//                System.out.println("i mod 3 " + i);
                tuple = new Tuple( 2.54, 2.678884224, "pet " + i);
                trie.add(tuple);
            }
            else if (i % 5 == 0) {
//                System.out.println("i mod 5 " + i);
                tuple = new Tuple('d', 3.1458, 1.98643320, 'm', "dog " + i);
                trie.add(tuple);
            }
            else if (i % 7 == 0) {
//                System.out.println("i mod 7 " + i);
                tuple = new Tuple(false, 3.1458, 1.945343320, 'b', "dog " + i);
                trie.add(tuple);
            }
            else if (i % 25 == 0) {
//                System.out.println("i mod 29 " + i);
                tuple = new Tuple(false, "str " + true, 1.98643320, 'm', "dog " +
                        i, i);
                trie.add(tuple);
            }
            else if (i % 77 == 0) {
//                System.out.println("i mod 77 " + i);
                tuple = new Tuple(false, "str " + true, 1.98643320, 'c',
                        "dog " + i, i, 10.0 + i);
                trie.add(tuple);
            }
            else {
//                System.out.println("i mod else " + i);
                tuple = new Tuple("ana ", 'v', 22.00 + i, 2500 + "bob " + i,
                        true, 2.777777444331111, 2*i, "bob the " + 4*i);
                trie.add(tuple);
            }
        }

        for (int i = 0; i < 60000; i++) {
            if (i % 2 == 0) {
                trie.search("anas " + i, 2);
                trie.remove("anas " + 2*i, 2);
            }
            else if (i % 3 == 0) {
                trie.search(2.54, 2.678884224, "pet " + i);
                trie.remove(2.54, 2.678884224, "pet " + 3*i);
            }
            else if (i % 7 == 0) {
                trie.search(false, 3.1458, 1.945343320, 'b', "dog " + i);
                trie.remove(false, 3.1458, 1.945343320, 'b', null);
            }
            else if (i % 25 == 0) {
                trie.search(false, "str " + true, 1.98643320, 'm', null,
                        i);
                trie.remove(false, "str " + true, 1.98643320, 'm', null,
                        2*i);
            }
            else {
                trie.search(null, 'v', 22.00 + i, null,
                        true, 2.777777444331111, 2*i, "bob the " + 4*i);
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time + " millis, it takes");
    }
}
