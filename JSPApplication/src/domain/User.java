package domain;

/**
 * **********************************************************
 *
 * @Project: 数据库关联表
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 09:14
 * @description:
 ************************************************************/
public class User {


    /*   id int primary key auto_increment,
                     name varchar(20) not null,
                     gender varchar(5),
                     age int,
                     address varchar(32),
                     qq	varchar(20),
                     email varchar(50)*/
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String qq;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", gender='" + gender + '\'' +
               ", age=" + age +
               ", address='" + address + '\'' +
               ", qq='" + qq + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}
