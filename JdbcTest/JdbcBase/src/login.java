import utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;


/**
 * @description: 判断用户登录是否成功
 * @author: Gavincoder
 * @date 2019-07-16 12:38
 * @version: 1.0
 */
public class login {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String user = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();

        boolean t = new login().test02(user, password);
        if (t) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登录失败");
        }


    }

    public boolean test(String user, String password) {

        //1.连接 connection
        Statement stat = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();

            stat = conn.createStatement();
            //字符串拼接
            String sql = "select * from account where user='" + user + "'and password='" + password + "'  ";
            System.out.println(sql);
            rs = stat.executeQuery(sql);
            //如果有数值,则返回的是 true
            return rs.next();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, stat, rs);
        }

        return false;
    }

    public boolean test02(String user, String password) {

        //1.连接 connection
        PreparedStatement pstat = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();


            //字符串占位
            String sql = "select * from account where user=? and password=? ";
            pstat = conn.prepareStatement(sql);
            //占位从1开始算
            pstat.setString(1, user);
            pstat.setString(2, password);
            //执行不需要的再输入sql了
            rs = pstat.executeQuery();
            //如果有数值,则返回的是 true
            return rs.next();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, pstat, rs);
        }

        return false;
    }

}
