import utils.JDBCUtils;

import java.sql.*;

public class connTest02 {

    public static void main(String[] args) {


        //使用 jdbcutils 工具类

        //0.连接对象作用域提升
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;


        try {
            //使用工具类
            conn = JDBCUtils.getConnection();
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
           JDBCUtils.close(conn,stat,resultSet);


        }


    }
}
