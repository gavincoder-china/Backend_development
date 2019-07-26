package web.servlet;

import domain.Account;
import org.apache.commons.beanutils.BeanUtils;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 16:05
 * @description:
 ************************************************************/
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取登陆的对象map
        Map<String, String[]> map = req.getParameterMap();
        //使用BeanUtil将map封装到account内
        Account login = new Account();
        try {
            BeanUtils.populate(login, map);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        // 这边我们还要判断下验证码

        //用户输入的验证码
        String verifycodeLogin = map.get("verifycode")[0];
        //后台生成的验证码
        HttpSession session = req.getSession();
        String verifycodeReal = (String) session.getAttribute("verifycode");
        session.removeAttribute("verifycode");
        if (verifycodeLogin != null && verifycodeLogin.equalsIgnoreCase(verifycodeReal)) {
            //验证码正确
            //进行数据库查询操作
            //获取到login对象了,现在可以调用service的方法
            LoginService loginService = new LoginServiceImpl();
            //获取到的登陆的结果
            Long loginResult = loginService.login(login);
            if (loginResult != 0) {
                //登录成功
                //重定向
                //登录状态存入session,方便过滤器检测是否登录
                session.setAttribute("success","succsee");

                resp.sendRedirect(req.getContextPath() + "/index.jsp");


            } else {
                //登录失败

                req.setAttribute("login", "用户名或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);

            }
        } else {
            //验证码错误
            req.setAttribute("login", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
