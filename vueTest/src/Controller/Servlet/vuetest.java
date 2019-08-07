package Controller.Servlet;

import Entity.User;
import Entity.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vuetest")
public class vuetest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        System.out.println(user);
        ObjectMapper objectMapper = new ObjectMapper();
        User users = objectMapper.readValue(user, User.class);
        System.out.println(users);
        System.out.println(users.getUsername());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
