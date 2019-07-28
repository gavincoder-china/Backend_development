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
 * @Date : 2019-07-25 19:11
 * @description:
 ************************************************************/
@WebServlet("/addServlet")
public class AddServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取输入的数据
        Map<String, String[]> map = req.getParameterMap();

        //创建用户Bean
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用userservice方法
        UserService userService=new UserServiceImpl();

        Integer addResult = userService.add(user);
        if (addResult!=0){
            //添加成功,跳转到列表页面
            resp.sendRedirect(req.getContextPath()+"/findUserByPageServlet");
        }else {
            System.out.println("添加失败");

        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
