package dao.impl;

import dao.UserDAO;
import entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-17 16:59
 * @description:
 ************************************************************/
public class UserDAOImpl implements UserDAO {

private static int count=0;


    @Override
    public int insert(User user) {

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());



        String sql = "insert into users(name,age) values(?,?)";


        count=template.update(sql, user.getName(), user.getAge());


        return count;
    }












    @Override
    public int delete(User user) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "delete from user users where id=?";
        count = template.update(sql, user.getId());
        return count;
    }

    @Override
    public int update(User user) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update users set name=? where id=?";
        count = template.update(sql,user.getName() ,user.getId());
        return count;
    }
}
