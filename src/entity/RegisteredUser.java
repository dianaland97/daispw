package entity;

public class RegisteredUser extends User {
    private String password;
    private String username;
    private String email;
    private String name;
    private String surname;

    public RegisteredUser(String name, String pass, String email, String r, String pick) {
        super(r, pick);
        this.username = name;
        this.password = pass;
        this.email = email;
    }

    @Override
    public String whoIam(){
        return this.username;
    }

    public String getAddress(){
        return this.email;
    }

    public String getPass() {
        return this.password;
    }
}
