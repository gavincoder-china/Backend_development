<%--
  Created by IntelliJ IDEA.
  User: gavincoder
  Date: 2019/8/19
  Time: 上午8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<form action="/hello/loginEntity" method="get">

    <input type="text" name="name" placeholder="用户名"/> <br>
    <input type="password" name="password" placeholder="密码"/> <br>
    <input type="number" name="age" placeholder="年龄"/> <br>
    男 <input type="radio" name="gender" value="男"/> <br>
    女 <input type="radio" name="gender" value="女"/> <br>


    <button type="submit">提交</button>


</form>
<a href="/hello/loginView">tiaohzuan</a>


<form action="/hello/restTest" method="post">
    <input type="submit" value="增">
</form>

<form action="/hello/restTest" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删">
</form>

<form action="/hello/restTest" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="改">
</form>

<form action="/hello/restTest" method="get">
    <input type="submit" value="查">
</form>

</body>
</html>
