package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @description: druid连接池工具类
 * @author: Gavincoder
 * @date 2019-07-16 17:00
 * @version: 1.0
 */
public class JDBCUtils_new {
    private static DataSource ds;

    static {

        try {
            //加载配置文件

            Properties props = new Properties();
            InputStream resourceAsStream = JDBCUtils_new.class.getClassLoader().getResourceAsStream("druid.properties");
            props.load(resourceAsStream);

            //获取dataSource
            ds = DruidDataSourceFactory.createDataSource(props);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //方法1:获取连接的方法
    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }

    //方法2:关闭/归还连接

    public static void close(Connection conn, Statement stat, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (stat != null) {
            try {
                stat.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close(); //归还连接
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(Connection conn, Statement stat) {
        //调用三个参数的方法,最后一个给null值
        //简化代码,骚气骚气

        close(conn, stat, null);
    }

    //方法3:获取连接池
    public static DataSource getDataSource() {
        return ds;

    }


}
