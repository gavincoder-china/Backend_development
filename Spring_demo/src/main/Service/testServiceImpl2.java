package main.Service;

import main.DAO.testDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-15 10:03
 * @description:
 ************************************************************/
@Service
public class testServiceImpl2 implements testService2 {
@Autowired
private testDao2 dao;



    @Override
    public void findService() {
        System.out.println("service层");
        dao.find();
    }
}
