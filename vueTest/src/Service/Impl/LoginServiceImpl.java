package Service.Impl;

import DAO.Impl.LoginDAOImpl;
import DAO.LoginDAO;
import Service.LoginService;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-02 09:57
 * @description:
 ************************************************************/
public class LoginServiceImpl implements LoginService {
    @Override
    public Integer login(String username, String password) {
      //调用 dao
        LoginDAO dao=new LoginDAOImpl();
        Integer login = dao.login(username, password);

        return login;
    }
}
