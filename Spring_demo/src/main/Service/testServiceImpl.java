package Service;

import DAO.testDao;

import javax.swing.*;

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
public class testServiceImpl implements testService {

private testDao dao;

    public void setDao(testDao dao) {
        this.dao = dao;
    }

    @Override
    public void findService() {
        System.out.println("service层");
        dao.find();
    }
}
