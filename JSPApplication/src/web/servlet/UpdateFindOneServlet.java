package web.servlet;

import domain.User;
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
 * @Date : 2019-07-26 09:08
 * @description:
 ************************************************************/
@WebServlet("/updateFindOneServlet")
public class UpdateFindOneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取id,然后在数据库中查询,回显数据
        String id = req.getParameter("id");
        Integer idReal = Integer.parseInt(id);
        //调取service方法来进行操作

        UserService userService = new UserServiceImpl();

        User user = userService.findOne(idReal);

        //查询到数据后将数据存到request中
        req.setAttribute("user", user);
        //通过request转发给update.jsp
req.getRequestDispatcher("/update.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
