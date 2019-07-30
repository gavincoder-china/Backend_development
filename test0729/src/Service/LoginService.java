package Service;

import org.springframework.dao.support.DaoSupport;

public interface LoginService {

    //登录

     Integer login(String name,String password);
}
