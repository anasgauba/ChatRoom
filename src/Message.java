/**
 * @version date: 2018-09-30
 * @author Anas Farooq Gauba
 */
public class Message {
    private TrieSpace space;

    public Message() {
        this.space = new TrieSpace();
    }
    public void addMsg(Tuple tuple) {
        space.add(tuple);
    }
    public String getLastTenMsgs() {
        return "";
    }
}
