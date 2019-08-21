package main.Controller;

import main.Entity.Book;
import main.Entity.Users;
import main.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-21 11:27
 * @description:
 ************************************************************/
@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService service;


    @RequestMapping("selectAll")
    @ResponseBody
    public List<Book> selectAll() {

        List<Book> list = service.selectAll();
        System.out.println("controller");
        System.out.println(list);
        return list;
    }

}
