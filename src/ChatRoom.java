import javafx.scene.layout.BorderPane;

import java.util.Collection;

/**
 * @version date: 2018-09-29
 * @author Anas Farooq Gauba
 */
public class ChatRoom {
    private TrieSpace space;
    private Tuple message;
    private User bob = new User();
    private User john = new User();
    private User tim = new User();
    private User smith = new User();


    public ChatRoom() {
        this.space = new TrieSpace();
    }


    public void printActiveUsers() {

    }

    public void addUsers() {
        bob.addMe("user", "Bob");
        john.addMe("user", "John");
        tim.addMe("user", "Tim");
        smith.addMe("user", "Smith");
    }

    public void printAllUsers() {

    }

    public int getSpaceSize() {
        return space.getMapSize();
    }
    public void printLastTenMsgs() {
        Tuple tuple = new Tuple("activeUser", bob);
        space.add(tuple);
    }

    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.addUsers();
        chatRoom.getSpaceSize();
    }
}
