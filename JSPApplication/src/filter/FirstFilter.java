package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 19:35
 * @description:
 ************************************************************/
@WebFilter("/*")
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置post方式的编码
        servletRequest.setCharacterEncoding("utf-8");

        //检测是否登录  这边进行判断,不对login.jsp进行过滤

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession();

        String uri = request.getRequestURI();

        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCode")) {


            //如果是login.jsp,就放行
            filterChain.doFilter(servletRequest, servletResponse);


        } else {
            Object success = session.getAttribute("success");
            if (success != null) {

                //登陆成功
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //登录失败
                request.setAttribute("login", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);

            }

        }


    }
}
