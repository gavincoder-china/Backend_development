package main.Controller;

import main.Entity.Users;
import main.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
        // System.out.println(user.getName()+user.getPassword());
        Users gavin = service.login(user.getName(), user.getPassword());

        System.out.println(gavin);

        return gavin;
    }

    @RequestMapping("register")
    @ResponseBody
    public boolean register(@RequestBody Users user) {

        Integer register = service.register(user);

        if (register == 0) {
            return false;
        } else {
            return true;
        }
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public List<Users> selectAll() {

        List<Users> list = service.selectAll();
        System.out.println("controller");
        System.out.println(list);
        return list;
    }


}
