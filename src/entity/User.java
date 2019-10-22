package entity;


public class User {
    private String role;
    private String profilepick;

    public User(String role, String img) {
        this.role = role;
        this.profilepick = img;
    }

    public String getRole(){
        return this.role;
    }

    public String whoIam(){
        return "guest";
    }

    public String getProfilePickPath() {
        return profilepick;
    }
}
