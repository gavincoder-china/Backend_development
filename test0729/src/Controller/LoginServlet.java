package Controller;

import Service.LoginService;
import Service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取数据
        String name = request.getParameter("name");
        String password = request.getParameter("password");


        System.out.println(name+password);
        //将数据交给service

        LoginService service=new LoginServiceImpl();
        Integer login = service.login(name, password);
        if (login>0){

            System.out.println("登陆成功");
        }else {

            System.out.println("登录失败");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);

    }
}
