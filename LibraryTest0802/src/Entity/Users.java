package Entity;

import java.util.Date;

/**
 * **********************************************************
 *
 * @Project:  用户信息类;
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-02 09:07
 * @description:
 ************************************************************/
public class Users {

    private Integer userId ;
    /** user_code */
    private String userCode ;
    /** password */
    private String password ;
    /** email */
    private String email ;
    /** gender */
    private Integer gender ;
    /** register */
    private Date register ;
    /** last_logintime */
    private Date lastLogintime ;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getRegister() {
        return register;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public Date getLastLogintime() {
        return lastLogintime;
    }

    public void setLastLogintime(Date lastLogintime) {
        this.lastLogintime = lastLogintime;
    }

    @Override
    public String toString() {
        return "Users{" +
               "userId=" + userId +
               ", userCode='" + userCode + '\'' +
               ", password='" + password + '\'' +
               ", email='" + email + '\'' +
               ", gender=" + gender +
               ", register=" + register +
               ", lastLogintime=" + lastLogintime +
               '}';
    }
}
