import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @version date: 2018-09-29
 * @author Anas Farooq Gauba
 */
public class UserList {
    ArrayList<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public User get(int index) {
        return users.get(index);
    }
    public ArrayList<User> getAllUsers() {
        return users;
    }
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
