package DAO;

import Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-15 10:02
 * @description:
 ************************************************************/
@Repository
public class testDaoImpl2 implements testDao2 {


    @Autowired
    private JdbcTemplate template;

    @Override
    public void find() {
        String sql = "select * from book";
        BeanPropertyRowMapper<Book> bookBeanPropertyRowMapper = new BeanPropertyRowMapper<>(Book.class);
        List<Book> query = template.query(sql, bookBeanPropertyRowMapper);
        for (Book b : query) {
            System.out.println(b);
        }

        System.out.println("dao层实现");

    }
}
