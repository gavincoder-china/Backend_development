<%--
  Created by IntelliJ IDEA.
  User: gavincoder
  Date: 2019/8/20
  Time: 下午1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="">

    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"/></td>
        </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" name="password"/></td>
      </tr>

      <tr>
        <td colspan="2"><input type="button" value="登录"/></td>
      </tr>
      <tr>
        <td colspan="2" id="error" style="color: red"></td>
      </tr>
    </table>

</form>
</body>
</html>
