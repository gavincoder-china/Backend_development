package Controller.Servlet;

import Entity.BookInfo;
import Service.BookService;
import Service.Impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/listAllServlet")
public class ListAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookService service=new BookServiceImpl();
        List<BookInfo> books = service.ListAll();
        //测试
        //        Iterator<BookInfo> iterator = books.iterator();
        //        while (iterator.hasNext()){
        //            System.out.println(iterator.next());
        //        }



        request.setAttribute("books",books);
        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
