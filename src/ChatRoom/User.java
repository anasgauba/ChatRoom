package ChatRoom;
/**
 * User class has name and active fields.
 * Just getters and setters for this User class.
 * User has the information of his/her name and whether
 * he/she is active.
 * @version date: 2018-09-29
 * @author Anas Farooq Gauba
 */
public class User {

    private String name;
    private boolean isActive;

    /**
     * Construct a user with given name and status.
     * @param name of user.
     * @param isActive status for online/offline.
     */
    public User(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    /**
     * @returns the name of the user.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the user active or not active.
     */
    public boolean isActive() {
        return this.isActive;
    }

    /**
     * Sets the user to either active or not active.
     * @param active true/false
     */
    public void setActive(boolean active) {
        this.isActive = active;
    }
}
