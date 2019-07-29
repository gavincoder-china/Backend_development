package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * **********************************************************
 *
 * @Project: 工具类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 11:01
 * @description:  作用是获取数据库连接池,为JDBCTemplate做基础
 ************************************************************/
public class JDBCUtils {
    //使用的是阿里巴巴的Druid数据库连接池
    //1.创建dataSource
   public static   DataSource ds;

    //读取配置
    static {

        Properties props = new Properties();
        try {
            props.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds= DruidDataSourceFactory.createDataSource(props);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    //获取数据库连接池
    public static DataSource getDataSource(){

        return ds;

    }




}
