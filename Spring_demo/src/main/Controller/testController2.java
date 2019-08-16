package main.Controller;

import main.Service.testService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-15 10:04
 * @description:
 ************************************************************/
@Controller("aa")
public class testController2 {


    public void findController() {

        System.out.println("Controller层");
        service.findService();

    }


    @Autowired
    private testService2 service;


}
