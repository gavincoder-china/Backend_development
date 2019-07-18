package Summary;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * @description: 练习一下druid的连接池
 * @author: Gavincoder
 * @date 2019-07-16 18:34
 * @version: 1.0
 */
public class SummaryUtils {

    //要记得连接池的逻辑,他是一个conn的池子
    private static DataSource ds;


    //静态代码块加载
    static {

        //获取properties
        Properties props = new Properties();
        try {
            props.load(SummaryUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //druid工厂类给ds创建对象
            ds = DruidDataSourceFactory.createDataSource(props);


        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }

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
    public static void close(Connection conn,Statement stat){

        close(conn,stat,null);

    }
    //获取连接池
    public static DataSource getDataSource(){

        return ds;

    }

}
