<%--
  Created by IntelliJ IDEA.
  User: gavincoder
  Date: 2019-07-29
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="${pageContext.request.contextPath}/loginServlet">
    <input type="text" name="name" placeholder="用户名">
    <input type="password" name="password" placeholder="密码">
    <input type="submit" value="提交">
  </form>

  </body>
</html>
