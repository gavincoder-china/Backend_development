package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

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
private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());




    @Override
    public List<User> findAll() {

        String sql="select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public Integer add(User user) {
        String sql="insert into user(name,gender,age,address,qq,email) values(?,?,?,?,?,?)";
        Integer update = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        return update;
    }

    @Override
    public Integer del(Integer id) {

        String sql="delete from user where id=?";
        Integer result = (Integer) template.update(sql, id);
        return result;
    }

    @Override
    public User findOne(Integer id)  {
        String sql="select * from user where id=?";
        Map<String, Object> map = template.queryForMap(sql, id);
        User user=new User();
        try {
            BeanUtils.populate(user,map);
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

        String sql="update user set gender=?,age=?,address=?,qq=?,email=? where id=?";

        Integer updateResult = template.update(sql, user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(),user.getId());
        return updateResult;
    }
}
