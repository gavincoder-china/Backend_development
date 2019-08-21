package main.Service;

import main.Entity.Users;

import java.util.List;

public interface UserService {
    Users login(String name, String password);
    Integer register(Users user);
    List<Users> selectAll();
}
