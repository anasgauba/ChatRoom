import java.util.Calendar;
import java.util.Random;

/**
 * Stress testing class to test the tuple space.
 * @version date: 2018-09-20
 * @author Anas Farooq Gauba
 */
public class Test {
    public static void main(String[] args) {
        Object[] randomObject;
        Random randomTuple = new Random();
        TrieSpace trie = new TrieSpace();
        Tuple tuple = null;

//        Calendar calendar = Calendar.getInstance();
        long time = System.currentTimeMillis();
//        calendar.setTimeInMillis(time);
//        System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + ":" +
//                calendar.get(Calendar.MILLISECOND));
        System.out.println(time);
        for (int i = 0; i < 10000; i++) {
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
                        "dog " +
                        i, i, 10.0 + i);
                trie.add(tuple);
            }
            else {
//                System.out.println("i mod else " + i);
                tuple = new Tuple("ana ", 'v', 22.00 + i, 2500 + "bob " + i,
                        true, 2.777777444331111, 2*i, "bob the " + 4*i);
                trie.add(tuple);
            }
        }
        long time2 = System.currentTimeMillis();

//        System.out.println(trie.getMapSize());
        System.out.println(time2 - time + " millis");

//        trie.remove("anas " + 4, null);
        trie.search("anas " + 4, 2);
//        trie.search('c', 2.54, 2.678884224, null);
//        trie.remove("anas " + 4, 2, 5);
    }
}
