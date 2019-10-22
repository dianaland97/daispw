package entity;

public abstract class Announcement {
    protected String owner;
    protected String creationDate;

    public Announcement(String ownernick, String creationDate) {
        this.owner = ownernick;
        this.creationDate = creationDate;
    }

    public abstract String myType();

    public String userOwner(){
        return owner;
    }
}
