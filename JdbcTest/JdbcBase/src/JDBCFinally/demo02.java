package JDBCFinally;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @description: 使用jdbcTemplate的方法来进行增删改查
 * @author: Gavincoder
 * @date 2019-07-17 09:36
 * @version: 1.0
 */
public class demo02 {

    public static void main(String[] args) {

        JdbcTemplate template = new JdbcTemplate(JDBCTools.getDataSource());

        //增
        String insert = "insert into account values(?,?,?)";
        template.update(insert, "ping", "520", 99999);

        //删
        String delect = "delete from account where user=?";

        template.update(delect, "王五");
        //改
        String update="update account set money=? where user=?";
        template.update(update,9999,"betty");
        //查
        String select ="select * from account where user=?";
        List<Map<String, Object>> gavin = template.queryForList(select, "gavin");
        System.out.println(gavin);


    }

}
