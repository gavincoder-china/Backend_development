package TestDemo;

import Entity.User;
import Mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-10 10:02
 * @description:
 ************************************************************/
public class test01 {
    private  SqlSession sqlSession =null;
    private  UserMapper mapper =null;
    @Before
    public void before() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();


        SqlSessionFactory factory = ssfb.build(is);
        sqlSession = factory.openSession();

         mapper = sqlSession.getMapper(UserMapper.class);


    }
    @After
    public void after(){

        sqlSession.commit();
        sqlSession.close();

    }


    @Test
    public void demo01() {


        List<User> users = mapper.queryAll();


        System.out.println(users);


    }

    @Test
    public void demo02(){

        User user = new User();
        user.setId(99);
        user.setUsername("myra");
        user.setPassword("68236127");
        int add = mapper.add(user);
        System.out.println(add);
    }

    @Test
    public void demo03(){


        int del = mapper.del(66);
        System.out.println(del);
    }
    @Test
    public void demo04(){
        User user = new User();
       // user.setId(99);
        user.setUsername("xxxxx");
        user.setPassword("68236127");

        int del = mapper.updateById(user,0);
        System.out.println(del);
    }

    @Test
    public void demo05(){


        List<User> del = mapper.selectByUsernameLike("王");

        System.out.println(del);
    }

    @Test
    public void demo06(){


        User u = mapper.selectByUsernameAndId("王五", 55);


        System.out.println(u);
    }
}
