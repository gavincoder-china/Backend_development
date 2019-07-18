package JDBCFinally;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

/**
 * @description: 重写工具类
 * @author: Gavincoder
 * @date 2019-07-17 08:58
 * @version: 1.0
 */
public class JDBCTools {

    //1.创建datasource对象
    private static DataSource dataSource;

    static {
        //获取数据库连接池
        Properties props = new Properties();
        try {
            props.load(JDBCTools.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(props);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @description  getConn方法
     * @author Gavin
     * @date 2019-07-17 09:04

     * @return java.sql.Connection
     * @throws
     * @since
    */
    public static Connection getConn(){
        try {
           return  dataSource.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @description  归还连接到连接池
     * @author Gavin
     * @date 2019-07-17 09:06

     * @return void
     * @throws
     * @since
    */
    public static void close(Connection conn, Statement stat, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static  void close(Connection conn,Statement stat){
        close(conn,stat,null);

    }

    //获取连接池
    public static DataSource getDataSource(){
        return  dataSource;
    }


}
