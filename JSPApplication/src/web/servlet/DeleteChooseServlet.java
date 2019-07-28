package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteChooseServlet")
public class DeleteChooseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String chooseIDArr = request.getParameter("chooseIDArr");
        //这边获取到的是字符串  6,7  以逗号,为分解,所以我们可以切成数组
        String[] chooseItems = chooseIDArr.split(",");

        //这个边可以做循环删除
        UserService userService=new UserServiceImpl();
      for(String item :chooseItems){



          Integer del = userService.del(Integer.parseInt(item));

      }
      //删完了之后, 再返回到userListServlet

        response.sendRedirect("/findUserByPageServlet");





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
