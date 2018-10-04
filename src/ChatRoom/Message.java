package ChatRoom;
import TupleSpace.*;

/**
 * @version date: 2018-09-30
 * @author Anas Farooq Gauba
 */
public class Message {
    private TrieSpace space;
    private int count;
    public Message() {
        this.space = new TrieSpace();
        count = 0;
    }
//    public int size() {
//        return space.getMapSize();
//    }
    public void addMsg(String time, User user, String message) {
        Tuple tuple = new Tuple(time, user, message);
        space.add(tuple);
        count++;
    }
    //TODO: this function.
    public String getLastTenMsgs() {
        String str = "";
        for (int i = 0; i < count; i++) {
//            str += space.search()
        }
        return str;
    }
}
