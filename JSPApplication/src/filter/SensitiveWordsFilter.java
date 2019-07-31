package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    //创建一个包含敏感词的集合
    private List<String> list = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
        //从敏感词汇.txt文件中获取敏感词汇
        try {
            //1.获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            //2.读取文件

            BufferedReader br = new BufferedReader(new FileReader(realPath));
            //3.将文件的每一行数据添加到list中
            String line = null;
            while ((line = br.readLine()) != null) {


                list.add(line);
            }
            br.close();
            System.out.println(list);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //代理模式
        ServletRequest proxy_req =(ServletRequest)Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                if ("getParameter".equals(method.getName())) {
                    //如果是这个方法,就拿到这个值
                    String value = (String) method.invoke(req, args);
                 //   System.out.println(value);
                    if (value != null) {
                        //来个for循环,遍历list
                        for (String item : list) {

                          ///  System.out.println(item);

                            if (value.contains(item)) {
                                value = value.replace(item, "***");
                            }
                        }


                    }

                    return value;
                }

                ///如果不是getParameter方法,就写原方法

                return method.invoke(req, args);

            }
        });


        //最后放行,注意方形的request
        chain.doFilter(proxy_req, resp);


    }


    public void destroy() {
    }
}
