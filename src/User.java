/**
 * @version date: 2018-09-29
 * @author Anas Farooq Gauba
 */
public class User {

    private TrieSpace space;
    private Tuple identity;
    private String name;
    private boolean isActive;

    public User() {
        this.space = new TrieSpace();
    }
    // Redo this part in chatroom instead
    public void addMe(String type, String user) {
        identity = new Tuple(type, user);
        space.add(identity);
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isActive() {
        return this.isActive;
    }
    public void setActive(boolean active) {
        this.isActive = active;
    }
    public String toString() {
        String str = "";
        str += identity.get(1);
        return str;
    }

    public void sendMsg(String msg) {

    }
}
