package gavin.code.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -1852970893526173954L;

    private Integer uid;

    private String username;

    private String password;

    private Integer gender;
}