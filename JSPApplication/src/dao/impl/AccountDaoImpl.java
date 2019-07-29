package dao.impl;

import dao.AccountDao;
import domain.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.nio.channels.SelectableChannel;
import java.util.List;

/**
 * **********************************************************
 *
 * @Project: 登录操作,查询数据库
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 16:16
 * @description: 返回查询出来的
 ************************************************************/

public class AccountDaoImpl implements AccountDao {

    private  JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());



    @Override
    public Long login(Account account) {

        String sql="select count(*) from accounts where username=? and password=?";

        Long query = template.queryForObject(sql, long.class, account.getUsername(), account.getPassword());

        return query;
        //等于1 成功 , 等于0 错误
    }
}
