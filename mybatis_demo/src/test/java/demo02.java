import Entity.Role;

import Mapper.RoleMapper;

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
 * @Date : 2019-08-12 13:53
 * @description:
 ************************************************************/
public class demo02 {

    private SqlSession sqlSession =null;
    private RoleMapper mapper =null;
    @Before
    public void before() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();


        SqlSessionFactory factory = ssfb.build(is);
        sqlSession = factory.openSession();

        mapper =  sqlSession.getMapper(RoleMapper.class);


    }
    @After
    public void after(){

        sqlSession.commit();
        sqlSession.close();

    }
   @Test
    public void  demo00(){


       List<Role> roles = mapper.get();
       System.out.println(roles);

   }

}
