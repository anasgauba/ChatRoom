package ChatRoom;
/**
 * @version date: 2018-09-29
 * @author Anas Farooq Gauba
 */
public class User {

    private String name;
    private boolean isActive;

    public User(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
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
}
