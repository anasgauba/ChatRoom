package ChatRoom;
import java.util.ArrayList;

/**
 * Utility class to keep track of all the users in a
 * list. Based on user is active (online), can get active
 * users. Can also get list all the users whether they are
 * active or not.
 * @version date: 2018-09-29
 * @author Anas Farooq Gauba
 */
public class UserList {
    private ArrayList<User> users;

    /**
     * Construct a list of users.
     */
    public UserList() {
        users = new ArrayList<>();
    }

    /**
     * Add user(s) to the list.
     * @param user user(s) to add.
     */
    public void addUser(User... user) {
        for (int i = 0; i < user.length; i++) {
            users.add(user[i]);
        }
    }

    /**
     * @return list of all the users.
     */
    public ArrayList<User> getAllUsers() {
        return users;
    }

    /**
     * Loops over the usersList and check at each index
     * whether that specific user isActive, if active,
     * add them to temporary list, return the temporary list
     * with all the users who are active.
     * @return active users only.
     */
    public ArrayList<User> getActiveUsers(){
        ArrayList<User> temp = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).isActive()) {
                temp.add(users.get(i));
            }
        }
        return temp;
    }
}
