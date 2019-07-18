package entity;

/**
 * **********************************************************
 *
 * @Project:  library图书馆库users表的用户类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-17 16:50
 * @description:
 ************************************************************/
public class User {

    private Integer id ;
    /** name */
    private String name ;
    /** password */
    private String password ;
    /** age */
    private Integer age ;
    /** sex */
    private Integer sex ;
    /** nickname */
    private String nickname ;
    /** usertype */
    private Integer usertype ;

    /** id */
    public Integer getId(){
        return this.id;
    }
    /** id */
    public void setId(Integer id){
        this.id = id;
    }
    /** name */
    public String getName(){
        return this.name;
    }
    /** name */
    public void setName(String name){
        this.name = name;
    }
    /** password */
    public String getPassword(){
        return this.password;
    }
    /** password */
    public void setPassword(String password){
        this.password = password;
    }
    /** age */
    public Integer getAge(){
        return this.age;
    }
    /** age */
    public void setAge(Integer age){
        this.age = age;
    }
    /** sex */
    public Integer getSex(){
        return this.sex;
    }
    /** sex */
    public void setSex(Integer sex){
        this.sex = sex;
    }
    /** nickname */
    public String getNickname(){
        return this.nickname;
    }
    /** nickname */
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    /** usertype */
    public Integer getUsertype(){
        return this.usertype;
    }
    /** usertype */
    public void setUsertype(Integer usertype){
        this.usertype = usertype;
    }



}
