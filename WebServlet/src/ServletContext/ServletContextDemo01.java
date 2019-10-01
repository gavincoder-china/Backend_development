package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo01")
public class ServletContextDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletContext对象

        //通过request获取对象
        ServletContext servletContext01 = request.getServletContext();

        //通过httpServlet获取对象
        // ServletContext servletContext02 = this.getServletContext();

        //定义文件名称
        String filename="a.jpg";

        //获取MIME类型
        String mimeType = servletContext01.getMimeType(filename);
        System.out.println(mimeType);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
