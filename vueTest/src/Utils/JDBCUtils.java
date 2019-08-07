package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * **********************************************************
 *
 * @Project: 数据库连接工具类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-02 09:10
 * @description:
 ************************************************************/
public class JDBCUtils {

    private static DataSource ds;


    static {

        Properties props = new Properties();
        try {
            props.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

            ds = DruidDataSourceFactory.createDataSource(props);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    //获取数据库连接池
    public static DataSource getDataSource() {

        return ds;
    }

}
