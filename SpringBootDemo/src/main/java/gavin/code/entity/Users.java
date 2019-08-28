package gavin.code.entity;

import lombok.Data;

@Data
public class Users {
    private Integer id;

    private String name;

    private String password;

    private Integer age;

    private Integer sex;

    private Integer usertype;

    private Integer roleid;

    private String email;
}