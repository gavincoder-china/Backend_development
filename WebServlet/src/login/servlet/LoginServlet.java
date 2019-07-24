package login.servlet;

import login.dao.LoginDao;
import login.domain.LoginUser;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * **********************************************************
 *
 * @Project: servlet类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-24 10:37
 * @description:
 ************************************************************/
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//设置编码
        req.setCharacterEncoding("utf-8");

       /* //设置请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //封装user对象
        LoginUser user = new LoginUser();
        user.setUsername(username);
        user.setPassword(password);*/



       //使用BeanUtils工具类
                //1.获取map集合
            Map<String, String[]> map = req.getParameterMap();
                //2.创建user对象
            LoginUser user = new LoginUser();


            try {

                //确保实体类中的属性名与获取到的属性名一致
                BeanUtils.populate(user,map);
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                e.printStackTrace();
            }


        //调用dao方法
        LoginDao dao = new LoginDao();
        LoginUser login = dao.login(user);







        //判断返回值
        if (login == null) {
            //登录失败
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        } else if (login != null) {
            //登陆成功
            // 存储数据
            req.setAttribute("login", login);


            //转发
            req.getRequestDispatcher("/successServlet").forward(req, resp);


        }


    }
}



