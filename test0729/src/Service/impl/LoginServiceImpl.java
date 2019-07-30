package Service.impl;

import Dao.LoginDao;
import Dao.impl.LoginDaoImpl;
import Service.LoginService;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-29 16:29
 * @description:
 ************************************************************/
public class LoginServiceImpl implements LoginService {

    @Override
    public Integer login(String name, String password) {
        LoginDao dao=new LoginDaoImpl();

        return   dao.login(name,password);
    }
}
