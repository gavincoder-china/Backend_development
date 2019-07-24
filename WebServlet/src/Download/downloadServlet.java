package Download;

import org.springframework.util.MimeType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//1.获取参数名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流,将文件加载进内存
        //2.1找到文件的服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);

        //2.2使用字节流关联
        FileInputStream fileInputStream = new FileInputStream(realPath);

        //3.设置response响应头  实现跳出下载框
        //3.1 设置响应头类型:content-type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type", mimeType);
        //3.2 设置响应头打开方式 content-disposition


                    //        中文文件问题
                    //        * 解决思路：
                    //        1. 获取客户端使用的浏览器版本信息
                    //        2. 根据不同的版本信息，设置filename的编码方式不同

                //解决中文文件名问题
                //3.2.1 获取user-agent 请求头
                String agent = request.getHeader("user-agent");
                //3.2.2 使用工具类编码文件名

        filename = DownLoadUtils.getFileName(agent, filename);

        response.setHeader("content-disposition","attachment;filename="+filename);

        //4.将输入流的数据写出到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len=0;
        while ((len=fileInputStream.read(bytes))!= -1){
            outputStream.write(bytes,0,len);

        }

        fileInputStream.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);

    }
}
