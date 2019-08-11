import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class demo01 {
    @Test
    public void test01() throws IOException {
        //读取配置文件

        InputStream in = Resources.getResourceAsStream("Mybatis-Config.xml");
        //需要sqlsessionFactoryBuilder
        System.out.println(in);
//        创建sqlsessionFactory
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
//        生产一个 sqlsession
        SqlSession session = ssf.openSession();
//        操作数据库
//        两个参数,第一个是要操作的sql,第二个是sql语句的参数

        Object o = session.selectOne("Mapper.UserMap.get", 1);
        System.out.println(o);
        session.close();
    }
}
