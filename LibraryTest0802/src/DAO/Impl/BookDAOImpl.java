package DAO.Impl;

import DAO.BookDAO;
import Entity.BookInfo;
import Utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-02 10:17
 * @description:
 ************************************************************/
public class BookDAOImpl implements BookDAO {
    private static JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<BookInfo> ListAll() {
        String sql="select * from book_info";

        List<BookInfo> books = template.query(sql, new BeanPropertyRowMapper<>(BookInfo.class));

        return books;
    }
}
