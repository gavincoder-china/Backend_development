package service.impl;

import dao.impl.AccountDaoImpl;
import domain.Account;
import service.LoginService;

/**
 * **********************************************************
 *
 * @Project: 实现登录service
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 16:34
 * @description:
 ************************************************************/
public class LoginServiceImpl implements LoginService {

    @Override
    public Long login(Account account) {

        //这边返回1或者0
        return new AccountDaoImpl().login(account);
    }
}
