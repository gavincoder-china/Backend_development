package gavin.code.service;

import gavin.code.dto.User;
import gavin.code.mapper.UserMapper;
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
 * @Date : 2019-09-23 11:05
 * @description:
 ************************************************************/
@Service
public class UsersService {


    @Autowired
    private UserMapper userMapper;

    public List<User>  select(){


        return userMapper.selectAll();
    }
}
