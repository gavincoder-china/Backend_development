package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

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
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-26 11:54
 * @description:
 ************************************************************/
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取数据
        Map<String, String[]> map = req.getParameterMap();

        User user = new User();

        try {
            BeanUtils.populate(user, map);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用UpdateService进行修改操作
        System.out.println(user.getId());
        UserService userService = new UserServiceImpl();

        Integer updateResult = userService.update(user);



        //将返回值传给update.jsp
        if (updateResult == 1) {
            //添加成功
            System.out.println("添加成功");
           req.setAttribute("success","true");
           req.setAttribute("user",user);
           req.getRequestDispatcher("/update.jsp").forward(req,resp);

        }

        //update.jsp页面接收返回数据,如果有,则弹出提示框


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
