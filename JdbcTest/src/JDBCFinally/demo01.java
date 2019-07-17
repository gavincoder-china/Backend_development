package JDBCFinally;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: preparedstatement方法进行增删改查
 * @author: Gavincoder
 * @date 2019-07-17 09:08
 * @version: 1.0
 */
public class demo01 {

    public static void main(String[] args) {


        demo01 demo = new demo01();
        //创建几个数据
        //增  王五,999,8989
        demo.insert("王五","999",8989);
        //删 张三
        demo.delete("张三");
        //改 gavin的💰改成999999
        demo.update("gavin",999999);
        //查
        demo.select();


    }

    private static Connection conn = null;
    private static PreparedStatement pstat = null;
    private static ResultSet rs = null;


    //使用jdbcTestDB数据库 account表

    //增加一条记录,但是三大属性都要用户输入
    public void insert(String user, String password, Integer money) {
        conn = JDBCTools.getConn();
        String sql = "insert into account values(?,?,?)";
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, user);
            pstat.setString(2, password);
            pstat.setInt(3, money);

            pstat.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.close(conn, pstat);
        }

    }

    //修改一个人的money,money跟user需要输入
    public void update(String user, Integer money) {

        conn = JDBCTools.getConn();
        String sql = "update account set money=? where user=?";
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setString(2, user);

            pstat.setInt(1, money);

            pstat.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.close(conn, pstat);
        }
    }
    //删除一条记录,user需哟输入
    public void delete(String user) {

        conn = JDBCTools.getConn();
        String sql = "delete from account where user=?";
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, user);


            pstat.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.close(conn, pstat);
        }
    }

    //查询所有人的信息,并打印
    public void select(){
        conn=JDBCTools.getConn();
        String sql ="select * from account";
        try {
            pstat=conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getInt(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.close(conn,pstat,rs);
        }
    }

}
