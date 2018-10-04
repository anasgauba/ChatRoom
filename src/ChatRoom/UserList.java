package ChatRoom;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @version date: 2018-09-29
 * @author Anas Farooq Gauba
 */
public class UserList {
    private ArrayList<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public void addUser(User... user) {
        for (int i = 0; i < user.length; i++) {
            users.add(user[i]);
        }
    }

//    public String getUserByName(String userName) {
//        String str = "";
//        for (int i = 0; i < users.size(); i++) {
//            if (users.equals(userName)) {
//                str += users.get(i).getName();
//            }
//        }
//        return str;
//    }

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
