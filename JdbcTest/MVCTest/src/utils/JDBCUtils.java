package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * **********************************************************
 *
 * @Project: jdbcUtils
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-17 16:37
 * @description: 工具类
 ************************************************************/
public class JDBCUtils {
    //使用druid数据库连接池
    private static DataSource ds = null;

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

    /**
     * @return java.sql.Connection
     * @throws
     * @description 获取连接conn
     * @author Gavin
     * @date 2019-07-17 16:42
     * @since
     */
    public static Connection getConn() {
        try {
            return ds.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @return void
     * @throws
     * @description 归还连接给数据库连接池
     * @author Gavin
     * @date 2019-07-17 16:45
     * @since
     */
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
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(Connection conn, Statement stat) {

        close(conn, stat, null);

    }

    /**
     * @return javax.sql.DataSource
     * @throws
     * @description 获取数据库连接池
     * @author Gavin
     * @date 2019-07-17 16:45
     * @since
     */
    public static DataSource getDataSource() {
        return ds;
    }


}
