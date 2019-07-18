package Summary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @description: 连接池工具类测试  实现查询一个名叫gavin的人的信息
 * @author: Gavincoder
 * @date 2019-07-16 18:58
 * @version: 1.0
 */
public class SummaryTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你想要查询的名字");
        String user=sc.nextLine();

        new SummaryTest().find(user);

    }

    private void find(String user) {
        //连接对象提升
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            conn=SummaryUtils.getConn();

            //定义sql语句
            String sql="select * from account where user=?";
            //给pstat赋值
            pstat=conn.prepareStatement(sql);
            //给pstat赋值
            pstat.setString(1,user);
            //执行
           rs = pstat.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("user")+":"+rs.getString("password")+":"+rs.getInt("money"));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SummaryUtils.close(conn,pstat,rs);
        }


    }

}
