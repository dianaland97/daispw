package bean;

public class AptManagementBean {

    private String nick;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    private String state;
    private int idRoom;

    public AptManagementBean(String nick) {
        this.nick = nick;
        setNick(this.nick);
    }

    public String getNick() {

        return nick;
    }

    public void setNick(String nick) {

        this.nick = nick;
    }

}
