package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * **********************************************************
 *
 * @Project:   这边接的是login项目
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 14:07
 * @description:  用户为登录的话,无法访问FilterSuccess.html页面
 ************************************************************/
@WebFilter("/FilterSuccess.html")
public class FilterDemo02 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request =(HttpServletRequest)servletRequest;

//        HttpServletResponse response=(HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        //获取一下filter  session
        Object filter = session.getAttribute("filter");

if (filter!=null){
    filterChain.doFilter(servletRequest,servletResponse);

}else {


}

    }


}
