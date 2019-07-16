package JDBCTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils_new;

import java.util.List;
import java.util.Map;

/**
 * @description: jdbc template的入门
 * @author: Gavincoder
 * @date 2019-07-16 19:12
 * @version: 1.0
 */
public class JDBCTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建jdbctemplate对象
        JdbcTemplate template=new JdbcTemplate(JDBCUtils_new.getDataSource());
        //3.调用方法
        //更新gavin的密码为123
        String sql="update account set password=? where user=?";
        String sql2="select * from account where user=? and password=? ";
        int i = template.update(sql, "123", "gavin");
        Map<String, Object> betty = template.queryForMap(sql2, "betty", "666");
        List<Map<String, Object>> betty1 = template.queryForList(sql2, "betty", "666");

        String sql3="select count(user) from account  ";
        Long count = template.queryForObject(sql3, Long.class);

        System.out.println(i);
        System.out.println(betty);
        System.out.println(betty1);
        System.out.println(count);

    }


}
