package gavin.code.service.impl;

import gavin.code.entity.Users;
import gavin.code.mapper.UsersMapper;
import gavin.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-28 19:23
 * @description:
 ************************************************************/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper mapper;
    @Override
    public List<Users> selectUser() {
        return mapper.selectAll();
    }
}
