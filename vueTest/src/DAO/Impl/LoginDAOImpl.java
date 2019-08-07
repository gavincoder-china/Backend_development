package DAO.Impl;

import DAO.LoginDAO;
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
 * @Date : 2019-08-02 09:58
 * @description:
 ************************************************************/
public class LoginDAOImpl implements LoginDAO {
    //初始化jdbctemplate
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Integer login(String username, String password) {

        String sql = "select count(1) from users where user_code=? and password=? ";

        Integer result = template.queryForObject(sql, Integer.class, username, password);
        //这边还要把最新的登录时间给到更新
        String dataSQL="update users set last_logintime=? where  user_code=?";
        template.update(dataSQL, new Date(), username);



        return result;
    }
}
