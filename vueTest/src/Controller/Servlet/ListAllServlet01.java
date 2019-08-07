package Controller.Servlet;

import Entity.BookInfo;
import Service.BookService;
import Service.Impl.BookServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listAllServlet01")
public class ListAllServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookService service=new BookServiceImpl();
        List<BookInfo> books = service.ListAll();
        //测试
        //        Iterator<BookInfo> iterator = books.iterator();
        //        while (iterator.hasNext()){
        //            System.out.println(iterator.next());
        //        }

          //在这边获取到了数据

        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();

        String s = mapper.writeValueAsString(books);
        System.out.println(s);
        response.getWriter().write(s);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
