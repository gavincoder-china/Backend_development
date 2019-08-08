package Controller.Servlet;

import Entity.Users;
import Service.Impl.RegisterServiceImpl;
import Service.RegisterService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();

        Users user=new Users();
        try {
            BeanUtils.populate(user,map);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //下面调用service方法
        RegisterService service=new RegisterServiceImpl();
        Integer result = service.register(user);

        System.out.println(result);
        if (result!=0){
            //注册成功
            request.getRequestDispatcher("/listAllServlet").forward(request,response);


        }else {

            request.getRequestDispatcher("/register.jsp").forward(request,response);

        }
        System.out.println(user);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
