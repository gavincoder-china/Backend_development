package main.Entity;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-19 15:21
 * @description:
 ************************************************************/
public class Login {
    private  String name;
    private  String password;

    @Override
    public String toString() {
        return "Login{" +
               "name='" + name + '\'' +
               ", password='" + password + '\'' +
               '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
