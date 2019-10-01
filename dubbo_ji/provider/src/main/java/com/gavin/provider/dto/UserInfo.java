package com.gavin.provider.dto;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    private Long id;

    private String userName;

    private String password;

    private Date createTime;

    private Integer userLevel;

    private Integer idDelete;

    private String phone;

    private String email;

    private Date updateTime;

    private int pSize;
    private int sPage;


    public int getpSize() {
        return pSize;
    }

    public void setpSize(int pSize) {
        this.pSize = pSize;
    }

    public int getsPage() {
        return sPage;
    }

    public void setsPage(int sPage) {
        this.sPage = sPage;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getIdDelete() {
        return idDelete;
    }

    public void setIdDelete(Integer idDelete) {
        this.idDelete = idDelete;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}