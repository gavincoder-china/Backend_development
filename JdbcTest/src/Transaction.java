
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:事务
 * @author: Gavincoder
 * @date 2019-07-16 14:47
 * @version: 1.0
 */
public class Transaction {
    public static void main(String[] args) {

        PreparedStatement pstat1 = null;
        PreparedStatement pstat2 = null;
        Connection conn = null;
        ResultSet rs = null;

        conn = JDBCUtils.getConnection();
        //开启事务(关闭自动提交)
        try {
            conn.setAutoCommit(false);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        String sql01="update account set money=money + 500 where user=?";
        String sql02="update account set money=money - 500 where user=?";


        try {
            pstat1=conn.prepareStatement(sql01);
            pstat1.setString(1,"gavin");

            pstat2=conn.prepareStatement(sql02);
            pstat2.setString(1,"betty");

            pstat1.executeUpdate();

            //手动增加异常事件
           int i=3/0;

            pstat2.executeUpdate();

           //如果没有异常的话,提交sql语句
           conn.commit();
        }
        catch (SQLException e) {
            //如果事务有异常,就回滚
            try {
                if (conn!=null){
                    conn.rollback();

                }
            }
            catch (Exception ex) {
                //异常情况考虑多一些,所以写成xception
                ex.printStackTrace();
            }

            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pstat1);
            JDBCUtils.close(null,pstat2);
        }


    }

}
