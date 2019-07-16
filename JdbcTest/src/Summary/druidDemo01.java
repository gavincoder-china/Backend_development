package Summary;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @description:
 * @author: Gavincoder
 * @date 2019-07-16 16:23
 * @version: 1.0
 */
public class druidDemo01 {

    public static void main(String[] args) throws Exception {

        //1.导入jar包
        //2.配置druid.properties文件
        //3.加载配置文件
        Properties props = new Properties();
        InputStream resourceAsStream = druidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
        props.load(resourceAsStream);
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(props);
        Connection conn=dataSource.getConnection();


    }


}
