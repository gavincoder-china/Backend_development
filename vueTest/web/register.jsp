<%--
  Created by IntelliJ IDEA.
  User: gavincoder
  Date: 2019-08-02
  Time: 10:54
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
    <h3 style="text-align: center;">注册</h3>
    <form action="${pageContext.request.contextPath}/registerServlet" method="post">
        <div class="form-group">
            <label for="userCode">用户名：</label>
            <input required type="text" name="userCode" class="form-control" id="userCode" placeholder="请输入用户名" />
            <span style="color: red;display: none" id="userNameCheck">该用户名太受欢迎了,换一个吧!</span>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input required type="password" name="password" class="form-control" id="password" placeholder="请输入密码" />
        </div>
        <div class="form-group">
            <label for="passwordCheck">确认密码：</label>
            <input type="password"  class="form-control" id="passwordCheck" placeholder="请输入密码" />
            <span id="check" style="display:none ;color: red"> 两次密码不一致 </span>
        </div>


        <div class="form-group">
            <label>性别: </label>
            <label class="radio-inline">
                <input required type="radio" name="gender"  value="1"> 男
            </label>
            <label class="radio-inline">
                <input required type="radio" name="gender"  value="0"> 女
            </label>

        </div>

        <div class="form-group">
            <label for="email">电子邮箱: </label>
            <input required type="email" name="email" class="form-control" id="email" placeholder="请输入电子邮箱" />
        </div>


        <hr />
        <div class="form-group" style="text-align: center;">

            <input class="btn btn btn-primary btn-lg" style="width: 45%" type="submit" value="注册">
            <a class="btn btn btn-success btn-lg" style="width: 45%"  onclick="window.history.back()" value="返回">返回</a>

        </div>
    </form>


</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>


<script>
    
    window.onload=function (ev) { 
        document.getElementById("passwordCheck").onblur=function () {
            //先获取密码框与密码验证框的数据
            var password = document.getElementById("password");
            var value01 = password.value;

            var value02 = this.value;
          console.log(value01);
          console.log(value02);

            if (value01!=value02){

               document.getElementById("check").style.display='block'
            }else{

                document.getElementById("check").style.display='none'

            }

        }
        
        //这边写个ajax

        
        
    }
    
</script>
</html>