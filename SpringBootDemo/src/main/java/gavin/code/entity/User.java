package gavin.code.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer uid;

    private String username;

    private String password;

    private Integer gender;

    private List<Order> order;



}