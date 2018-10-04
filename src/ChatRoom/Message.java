package ChatRoom;
import TupleSpace.*;
import java.time.LocalDateTime;

/**
 * @version date: 2018-09-30
 * @author Anas Farooq Gauba
 */
public class Message {
    private TrieSpace space;

    public Message() {
        this.space = new TrieSpace();
    }
    public void addMsg(String time, User user, String message) {
        Tuple tuple = new Tuple(time, user, message);
        space.add(tuple);
    }
    public String getLastTenMsgs() {

        return "";
    }
}
