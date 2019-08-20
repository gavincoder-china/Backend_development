package main.Controller;

import main.Entity.Users;
import main.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-20 15:17
 * @description:
 ************************************************************/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("login")
    @ResponseBody
    public Users login(@RequestBody Users user) {
        System.out.println(user.getName()+user.getPassword());
        Users gavin = service.login("aa", "654321");
        System.out.println(gavin);

        return gavin;
    }
    @RequestMapping("test")
    @ResponseBody
    public boolean test(){
        return true;
    }

}
