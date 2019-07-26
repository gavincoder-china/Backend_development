package service;

import domain.Account;

/**
 * @description   登录判断
 * @author Gavin
 * @date 2019-07-25 16:33

 * @return
 * @throws
 * @since
*/
public interface LoginService {
    public Long login(Account account);
}
