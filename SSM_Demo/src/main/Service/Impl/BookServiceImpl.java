package main.Service.Impl;

import main.Entity.Book;
import main.Mapper.BookMapper;
import main.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-21 11:29
 * @description:
 ************************************************************/
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper mapper;


    @Override
    public List<Book> selectAll() {
        List<Book> list = mapper.selectAll();
        return list;
    }
}
