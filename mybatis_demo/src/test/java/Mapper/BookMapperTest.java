package Mapper;

import Entity.Book;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-13 14:36
 * @description:
 ************************************************************/
public class BookMapperTest {
    private static BookMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(BookMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/BookMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(BookMapper.class, builder.openSession(true));
    }

    @Test
    public void testSelectByPrimaryKey() throws FileNotFoundException {
        Book book = mapper.selectByPrimaryKey(1);
        System.out.println(book);
    }


    @Test
    public void testSelectById() throws FileNotFoundException {
        List<Book> books = mapper.selectById(1);
        System.out.println(books);
    }

    @Test
    public void testSelectbyidin() throws FileNotFoundException {
        List<Integer> list=new ArrayList<>();

        list.add(1);
        list.add(2);
        List<Book> selectbyidin = mapper.selectbyidin(list);
        System.out.println(selectbyidin);
    }
}
