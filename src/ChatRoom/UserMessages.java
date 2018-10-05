package ChatRoom;
import TupleSpace.*;

import java.util.ArrayList;

/**
 * @version date: 2018-09-30
 * @author Anas Farooq Gauba
 */
public class UserMessages {
    private TrieSpace space;
    private ArrayList<String> timeStamp;

    /**
     *
     */
    public UserMessages() {
        this.space = new TrieSpace();
        timeStamp = new ArrayList<>();
    }

    /**
     *
     * @param time
     * @param user
     * @param message
     */
    public void addMsg(String time, User user, String message) {
        Tuple tuple = new Tuple(time, user.getName(), message);
        space.add(tuple);
        timeStamp.add(time);
    }
    //TODO: Based on time, show only 10 recent msgs not all from TupleSpace.
    public String getLastTenMsgs() {
        String temp = "";
        for (int i = 0; i < timeStamp.size(); i++) {
//            if (timeStamp.size() != 10) {
                temp += space.search(timeStamp.get(i), null, null).toString();
                temp += "\n";
//            }
        }
        System.out.println("String " + temp);
        return temp;
    }
}
