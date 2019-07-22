package request;

import com.sun.jdi.Value;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestdemo03")
public class requestdemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        System.out.println("测试获取单个数据");
        String username = request.getParameter("username");
        System.out.println(username);


        System.out.println("测试name获取");
        String[] learns = request.getParameterValues("learn");
        for (String learn : learns) {
            System.out.println(learn);
        }
        //测试names
        System.out.println("测试names枚举数组");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }

        //测试请求集合
        System.out.println("测试集合");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String s : keySet) {
            String[] strings = parameterMap.get(s);
            System.out.println(s);
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println("---------");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
