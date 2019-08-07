package Service.Impl;

import DAO.Impl.RegisterDAOImpl;
import DAO.RegisterDAO;
import Entity.Users;
import Service.RegisterService;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-02 11:07
 * @description:
 ************************************************************/
public class RegisterServiceImpl implements RegisterService {
    @Override
    public Integer register(Users user) {

        //调用dao

        RegisterDAO dao=new RegisterDAOImpl();
        Integer result = dao.register(user);
        return result;
    }
}
