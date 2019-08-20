package main.Service;

import main.Entity.Users;

public interface UserService {
    Users login(String name, String password);
}
