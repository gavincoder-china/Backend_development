package test;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;

/**
 * **********************************************************
 *
 * @Project:  测试增删改
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-17 17:11
 * @description:
 ************************************************************/
public class test {
    public static void main(String[] args) {
        User gavin = new User();
        gavin.setId(666);
        gavin.setName("gavin");


        UserDAO userDAO=new UserDAOImpl();

        int count = userDAO.update(gavin);

        System.out.println(count);


    }


}
