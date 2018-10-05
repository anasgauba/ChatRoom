package ChatRoom;
import TupleSpace.*;

import java.util.ArrayList;

/**
 * UserMessages class that keeps track of user messages in the tupleSpace,
 * abd what time the user has send a message. Storing user's message, userName,
 * and the time he/she sends a message into TrieSpace (which is TupleSpace).
 * In order to print recent messages, I am using a list to keep of times.
 * @version date: 2018-09-30
 * @author Anas Farooq Gauba
 */
public class UserMessages {
    private TrieSpace space;
    private ArrayList<String> timeStamp;

    /**
     * Construct UserMessages object to get the
     * access to tupleSpace. I am also saving times in a list to
     * have last 10 recent messages based on time.
     */
    public UserMessages() {
        this.space = new TrieSpace();
        timeStamp = new ArrayList<>();
    }

    /**
     * User types a message which then adds his/her message
     * noting the time, and his name to the tupleSpace.
     * This information is added to the user, I take this user's
     * name into account when adding his/her message to the tupleSpace.
     * In order to print recent last 10 messages, I keep track of times
     * at which user typed a message into the list, so that I can print
     * last ten recent msgs in printLastTenMsgs() method.
     * @param time at which user typed in message.
     * @param user that typed a message.
     * @param message of the this user.
     */
    public void addMsg(String time, User user, String message) {
        Tuple tuple = new Tuple(time, user.getName(), message);
        space.add(tuple);
        timeStamp.add(time);
    }

    //TODO: Based on time, show only 10 recent msgs not all from TupleSpace.
    /**
     * Prints the last ten recent messages. Based on
     * the recent time, I search the tuple in the tupleSpace and get its
     * toString value and concatenate to the temp string.
     * Returning them as strings so I can easily show it on scrollPane in
     * GameCoordinator.java.
     * @return the last ten recent messages.
     */
    public String printLastTenMsgs() {
        String temp = "";
        for (int i = 0; i < timeStamp.size(); i++) {
//            if (timeStamp.size() != 10) {
                temp += space.search(timeStamp.get(i), null, null).toString();
                temp += "\n";
//            }
        }
//        System.out.println("String " + temp);
        return temp;
    }
}
