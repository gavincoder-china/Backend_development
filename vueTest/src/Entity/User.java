package Entity;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-07 16:25
 * @description:
 ************************************************************/
public class User {

    private String username;
    private String password;
    private String gender;
    private String email;


    @Override
    public String toString() {
        return "User{" +
               "username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", gender='" + gender + '\'' +
               ", email='" + email + '\'' +
               '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
