package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * **********************************************************
 *
 * @Project: 用户表分页查询
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-28 17:36
 * @description:
 ************************************************************/
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数,当前页码
        String currentPage = req.getParameter("currentPage");
        //每页显示的条数
        String rows = req.getParameter("rows");

        if ("".equals(currentPage)||currentPage==null){
            currentPage="1";

        }
        if (rows==null||"".equals(rows)){

            rows="5";
        }

        //再获取条件查询的参数
        Map<String, String[]> condition = req.getParameterMap();



        //调用userService
        UserService userService = new UserServiceImpl();
        PageBean<User> pageBean = userService.findUserByPage(currentPage, rows,condition);


        //测试一下 http://localhost:8080/findUserByPageServlet?currentPage=1&rows=3
       // System.out.println(pageBean);


        //存储数据,将pageBean存入request
        req.setAttribute("pb", pageBean);
        //将条件查询的数据回存,实现回显
        req.setAttribute("condition",condition);
        //转发到list.jsp页面
        req.getRequestDispatcher("/list.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
