package gavin.code.dto;

import lombok.Data;

@Data
public class User {
    private Integer uid;

    private String username;

    private String password;

    private Integer gender;
}