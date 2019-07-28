package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 20:16
 * @description:
 ************************************************************/
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取id,id是int类型
        String id = req.getParameter("id");
       Integer idReal=Integer.parseInt(id);

        UserService userService=new UserServiceImpl();
        //执行代码
        Integer del = userService.del(idReal);

        if(del!=null){

            resp.sendRedirect(req.getContextPath()+"/findUserByPageServlet");
        }else{
            System.out.println("删除失败");
            resp.sendRedirect(req.getContextPath()+"/findUserByPageServlet");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
