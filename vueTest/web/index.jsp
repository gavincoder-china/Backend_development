<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gavincoder
  Date: 2019-08-02
  Time: 08:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>
    </title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container" style="width: 400px;margin-top: 100px">
    <h3 style="text-align: center;">用户登录</h3>


    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>
        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码"
                   style="width: 120px;"/>
            <a href="javascript:refreshCode()">
                <img style="margin-left: 30px" src="${pageContext.request.contextPath}/checkCode" title="看不清点击刷新" id="vcode"/>
            </a>
        </div>

        <hr/>
        <div class="form-group" style="text-align: center;">

            <input class="btn btn btn-primary btn-lg" style="width: 45%" type="submit" value="登录">
            <a class="btn btn btn-success btn-lg" style="width: 45%" href="/register.jsp" value="注册">注册</a>

        </div>
    </form>

    <!-- 出错显示的信息框 -->

    <c:if test="${login=='false'}">

        <div class="alert alert-warning alert-dismissible" role="alert" >
            <button type="button" class="close" data-dismiss="alert">
                <span>&times;</span></button>
            <strong>用户名或密码错误!</strong>
        </div>

    </c:if>

    <c:if test="${login=='Vcodefalse'}">

        <div class="alert alert-warning alert-dismissible" role="alert" >
            <button type="button" class="close" data-dismiss="alert">
                <span>&times;</span></button>
            <strong>验证码错误!</strong>
        </div>

    </c:if>



</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
<script>

    var refreshCode = function () {
        var vcode = document.getElementById("vcode");
        var time = new Date().getTime();
        vcode.src = "${pageContext.request.contextPath}/checkCode?" + time;
    }


</script>

</html>