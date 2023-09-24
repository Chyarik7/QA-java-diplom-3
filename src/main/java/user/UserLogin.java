package user;

public class UserLogin {
    private String email;
    private String password;
    public UserLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
    private UserLogin() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}