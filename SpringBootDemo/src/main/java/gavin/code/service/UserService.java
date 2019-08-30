package gavin.code.service;

import gavin.code.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectuser(Integer id);
}
