package Dao.impl;

import Dao.LoginDao;
import Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-29 16:31
 * @description:
 ************************************************************/
public class LoginDaoImpl implements LoginDao {
private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDs());
    @Override
    public Integer login(String name, String password) {


        String sql="select count(*) from users where name=? and password=? ";
        System.out.println(sql);
        System.out.println(name);
        System.out.println(password);

        Long query = template.queryForObject(sql, Long.class , name, password);

        Integer result=query.intValue();
        System.out.println(sql);
        return result;
    }
}
