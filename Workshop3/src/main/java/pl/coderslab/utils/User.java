package pl.coderslab.utils;

public class User {

    private  int id;
    private  String email;
    private  String userName;
    private  String password;

    public User(){
        this("email", "username", "password");
    }

    public User(String email, String userName, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "pl.coderslab.utils.User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
