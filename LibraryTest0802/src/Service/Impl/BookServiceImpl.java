package Service.Impl;

import DAO.BookDAO;
import DAO.Impl.BookDAOImpl;
import Entity.BookInfo;
import Service.BookService;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-02 10:16
 * @description:
 ************************************************************/
public class BookServiceImpl implements BookService {
    @Override
    public List<BookInfo> ListAll() {
        //调用dao
        BookDAO dao=new BookDAOImpl();
        List<BookInfo> books = dao.ListAll();
        return books;
    }
}
