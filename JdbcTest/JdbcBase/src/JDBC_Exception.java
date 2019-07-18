import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Exception {
    public static void main(String[] args) {
        //0.提升连接作用域
        Statement stat = null;
        Connection conn = null;

        //1.注册驱动,可不写

        //2.创建连接

        try {
            conn = DriverManager.getConnection("jdbc:mysql:///jdbcTestDB", "root", "123456");
            //3.定义 sql 语句
            String sql = "insert into person values('test',999)";
            //4.获取 statement
            stat = conn.createStatement();
            //5.执行 sql
            int ex = stat.executeUpdate(sql);
            //6.打印结果
            System.out.println(ex);
            if (ex > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
            //7.释放资源


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //7.释放资源,放在 finally 里面
            //(1)先释放 statement
            //为了避免空指针异常,先判断其时候为空
            if (stat != null) {
                try {
                    stat.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }


            }
            //(2)第二个释放 connection
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
}