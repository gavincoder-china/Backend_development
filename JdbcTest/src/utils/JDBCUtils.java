package utils;


import java.io.IOException;
import java.io.InputStream;

import java.sql.*;
import java.util.Properties;


public class JDBCUtils {
    //变量提升,写成静态的才能被静态代码块,静态方法所访问
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    /*
    propert文件的读取,读取一次即可
    使用静态代码块,只执行一次
     */
    static {

        try {
            //1.读取 properties 资源文件

            Properties props = new Properties();

            //2.加载文件
            //问题:如何获取到 jdbc.properties 文件的路径
            //解决方案:使用 classLoader 类加载器



           //方案1
          /*  ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            props.load(new FileReader(path));*/

          //方案2 代码少
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
           props.load(resourceAsStream);
            //3.获取属性赋值
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
            driver = props.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param
     * @return java.sql.Connection
     * @throws
     * @description 获取连接的工具对象
     * @author Gavin
     * @date 2019-07-16 10:54
     * @since
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * @param conn
     * @param stat
     * @return void
     * @throws
     * @description 关闭增删改的连接
     * @author Gavin
     * @date 2019-07-16 10:55
     * @since
     */
    public static void close(Connection conn, Statement stat) {
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

    /**
     * @param conn
     * @param stat
     * @param rs
     * @return void
     * @throws
     * @description 关闭查询操作的连接
     * @author Gavin
     * @date 2019-07-16 10:58
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

}
