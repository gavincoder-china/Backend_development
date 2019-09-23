package gavin.code.controller;

import gavin.code.dto.User;
import gavin.code.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-28 19:17
 * @description:
 ************************************************************/

@RestController
@RequestMapping(value = "/v1")
public class Controller {


    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/show")
    public List<User> select() {
        return usersService.select();
    }


}
