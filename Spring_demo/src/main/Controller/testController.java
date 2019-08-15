package Controller;

import Service.testService;

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
public class testController {


    public void findController() {

        System.out.println("Controller层");
        service.findService();

    }



    private testService service;

    public void setService(testService service) {
        this.service = service;
    }
}
