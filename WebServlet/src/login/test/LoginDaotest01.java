package login.test;


import login.dao.LoginDao;
import login.domain.LoginUser;
import org.junit.Test;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-24 10:12
 * @description:
 ************************************************************/
public class LoginDaotest01 {

    @Test
    public void testLogin() {

            LoginDao dao = new LoginDao();
            LoginUser user = new LoginUser();
            user.setId(1);
            user.setUsername("gavin");
            user.setPassword("123456");
            LoginUser login = dao.login(user);
            System.out.println(login);



    }
}
