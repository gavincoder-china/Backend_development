package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 10:52
 * @description:
 ************************************************************/
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<User> findAll() {

        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public Integer add(User user) {
        String sql = "insert into user(name,gender,age,address,qq,email) values(?,?,?,?,?,?)";
        Integer update = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        return update;
    }

    @Override
    public Integer del(Integer id) {

        String sql = "delete from user where id=?";

        Integer result = (Integer) template.update(sql, id);

        return result;
    }

    @Override
    public User findOne(Integer id) {
        String sql = "select * from user where id=?";
        Map<String, Object> map = template.queryForMap(sql, id);
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return user;
    }

    @Override
    public Integer update(User user) {

        String sql = "update user set gender=?,age=?,address=?,qq=?,email=? where id=?";

        Integer updateResult = template.update(sql, user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
        return updateResult;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义一个模板初始化sql

        String sql = "select count(*) from user where 1=1 ";

        //2.遍历map,拼接字符串
        StringBuilder sb = new StringBuilder(sql);

        Set<String> keySet = condition.keySet();

        //定义sql参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页的currentPage与rows两个条件
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //证明其有值,开始拼接sql,注意加空格
                sb.append(" and " + key + " like ? ");
                params.add('%' + value + '%');
            }

        }

        sql=sb.toString();
        Integer count = template.queryForObject(sql, Integer.class, params.toArray());

        System.out.println("查询出"+count);
        return count;
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {

        String sql = "select * from user where 1=1 ";

        //2.遍历map,拼接字符串
        StringBuilder sb = new StringBuilder(sql);

        Set<String> keySet = condition.keySet();

        //定义sql参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页的currentPage与rows两个条件
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //证明其有值,开始拼接sql,注意加空格
                sb.append(" and " + key + " like ?  ");
                params.add('%' + value + '%');
            }

        }
        //添加分页查询

        sb.append(" limit ?,?  ");
        //给params添加分页查询值
        params.add(start);
        params.add(rows);


        sql=sb.toString();

        System.out.println(sql);
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());

        System.out.println("总数据"+list);
        return list;

    }
}
