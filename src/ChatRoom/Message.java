package ChatRoom;
import TupleSpace.*;

import java.util.ArrayList;

/**
 * @version date: 2018-09-30
 * @author Anas Farooq Gauba
 */
public class Message {
    private TrieSpace space;
    private ArrayList<String> timeStamp;
    public Message() {
        this.space = new TrieSpace();
        timeStamp = new ArrayList<>();
    }
//    public int size() {
//        return space.getMapSize();
//    }
    public void addMsg(String time, User user, String message) {
        Tuple tuple = new Tuple(time, user, message);
        space.add(tuple);
        timeStamp.add(time);
    }
    //TODO: this function.
    public String getLastTenMsgs() {
        String temp = "";
        for (int i = 0; i < timeStamp.size(); i++) {
            if (timeStamp.size() != 10) {
                temp += space.search(timeStamp.get(i), null, null).toString();
                temp += "\n";
            }
        }
        System.out.println("String " + temp);
        return temp;
    }
}
