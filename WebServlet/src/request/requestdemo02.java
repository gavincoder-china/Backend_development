package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestdemo02")
public class requestdemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取请求头
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()){
//            String name = headerNames.nextElement();
//            String header = request.getHeader(name);
//            System.out.println(name+":"+header);
//        }

//判断浏览器
        String header = request.getHeader("user-agent");
        //Chrome 首字母要大写
        if (header.contains("Chrome")){
            System.out.println("chrome");
        }else  if (header.contains("Firefox")){
            System.out.println("Firefox");
        }

    }
}
