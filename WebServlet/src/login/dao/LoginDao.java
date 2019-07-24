package login.dao;

import login.Util.JDBCUtils;
import login.domain.LoginUser;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * **********************************************************
 *
 * @Project:登录的方法
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-24 09:50
 * @description:
 ************************************************************/
public class LoginDao {

    //声明JDBCtemplate对象公用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * @return login.domain.LoginUser
     * @throws
     * @description 登录方法
     * @author Gavin
     * @date 2019-07-24 10:03
     * @since
     */
    public LoginUser login(LoginUser loginUser) {
//给选定代码块加代码的快捷键 ctrl+alt+T

        try {
            //编写sql
            String sql = "select * from person where username=? and password=?";

            //调用template方法
            LoginUser user = template.queryForObject(sql, new BeanPropertyRowMapper<LoginUser>(LoginUser.class),
                                                     loginUser.getUsername(), loginUser.getPassword());

            return user;
        }
        catch (DataAccessException e) {
          return null;
        }


    }

}
