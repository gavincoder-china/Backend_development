package domain;

/**
 * **********************************************************
 *
 * @Project: 登录注册的JavaBean
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 16:09
 * @description:
 ************************************************************/
public class Account {

    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "Account{" +
               "username='" + username + '\'' +
               ", password='" + password + '\'' +
               '}';
    }
}
