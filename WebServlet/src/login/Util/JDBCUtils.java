package login.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * **********************************************************
 *
 * @Project: 工具类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-24 09:53
 * @description: 使用Druid连接池与JDBCtemplate
 ************************************************************/
public class JDBCUtils {

    private static DataSource ds;

    static {
      //加载配置文件
        Properties props = new Properties();

        try {
            props.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        //初始化连接
        try {
            ds = DruidDataSourceFactory.createDataSource(props);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    //获取连接池对象
    public static DataSource getDataSource() {

        return ds;
    }

    //获取连接connection对象
    public static Connection getConnection() {

        try {
            return ds.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
