import java.sql.*;

public class connTest {

    public static void main(String[] args) {


        //0.连接对象作用域提升
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        //1.注册驱动
        //mysql 5 之后可以省略注册步骤,因为已经在jar 包中写好了注册代码

       // Class.forName("com.mysql.jdbc.Driver");


        //2.创建连接
        //这边的 localhost 可以简写成 jdbc:mysql:///数据库名称

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTestDB", "root", "123456");
            //3.创建 sql 语句
            //增删改语句
            String sql1 = "insert into person(name,age) values('甲',55),('乙',66)";

            //查询语句
            String sql2 = "select * from person";

            //4.创建 statement 对象
            stat = conn.createStatement();

            //5.运行 sql 语句
            //增删改语句
            //返回值是影响的行数
            int ex = stat.executeUpdate(sql1);
            //查询语句
            resultSet = stat.executeQuery(sql2);

            //6.打印结果
            System.out.println("插入语句事件:" + ex);

            while (resultSet.next()) {
                //get 可以传下标,从 1 开始

                System.out.println(resultSet.getString(1) + ":" + resultSet.getInt(2));
                System.out.println(resultSet.getString("name") + ":" + resultSet.getInt("age"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //7.关闭连接
            if (resultSet != null) {
                try {
                    resultSet.close();
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
}
