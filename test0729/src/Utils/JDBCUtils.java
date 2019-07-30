package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * **********************************************************
 *
 * @Project:  工具类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-29 16:16
 * @description:
 ************************************************************/
public class JDBCUtils {

    private static DataSource ds;
    static {
        //获取配置文件
        Properties properties = new Properties();

        //加载文件
        try {
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("Druid.properties"));

         //加载ds
            ds= DruidDataSourceFactory.createDataSource(properties);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    //获取ds
    public static DataSource getDs(){

        return ds;

    }



}
