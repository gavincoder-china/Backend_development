package Controller.Servlet;

import Service.Impl.LoginServiceImpl;
import Service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 这边我们还要判断下验证码

        //用户输入的验证码
        String verifycodeLogin = request.getParameter("verifycode");

        //后台生成的验证码
        HttpSession session = request.getSession();
        String verifycodeReal = (String) session.getAttribute("verifycode");

        session.removeAttribute("verifycode");


        if (verifycodeLogin != null && verifycodeLogin.equalsIgnoreCase(verifycodeReal)) {

            //验证码正确
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            LoginService service = new LoginServiceImpl();
            Integer login = service.login(username, password);

            if (login >= 1) {

                response.sendRedirect("/listAllServlet");

            } else {


                //  登录失败

                request.setAttribute("login","false");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }



        }else {
            //验证码失败

            request.setAttribute("login","Vcodefalse");
            request.getRequestDispatcher("/index.jsp").forward(request,response);


        }













    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
