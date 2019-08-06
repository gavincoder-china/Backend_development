package Controller;

import DAO.FindDao;
import Service.FindService;
import Service.impl.FindServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;

@WebServlet("/findServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FindService service=new FindServiceImpl();
        String s = service.find();

        //response.setContentType("text/html;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(s);
        System.out.println(s);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
