package DAO.Impl;

import DAO.RegisterDAO;
import Entity.Users;
import Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-02 11:08
 * @description:
 ************************************************************/
public class RegisterDAOImpl implements RegisterDAO {
    private static JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public Integer register(Users user) {
        System.out.println("daozhela ");
        System.out.println(user);

        //参数,,user_code ,password gender  email
        String sql="insert into users(user_code,password,email,gender,register,last_logintime) values(?,?,?,?,?,?) ";
        Date date = new Date();


        int result = template.update(sql,user.getUserCode(),user.getPassword(),user.getEmail(),user.getGender(),date,date);




        return result;
    }
}
