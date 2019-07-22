<%--
  Created by IntelliJ IDEA.
  User: gavincoder
  Date: 2019-07-22
  Time: 08:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取用户登录名&密码</title>
</head>
<body>

<%

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if ("gavincoder".equals(username)&&"123456".equals(password)){

        response.sendRedirect("index.jsp");

    }else {
        response.sendRedirect("register.jsp");

    }

%>

用户名 :  <%= username%> <br>
密码   :  <%= password%>



</body>
</html>
