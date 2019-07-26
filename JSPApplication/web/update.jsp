<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>

    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form  action=" ${pageContext.request.contextPath}/updateServlet" method="post">

        <input type="text" class="form-control" id="id" name="id" readonly style="display: none" value="${user.id}"/>


        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" readonly value="${user.name}"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" value="${user.age}"/>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" id="address" class="form-control">
                <option value=""></option>
                <option value="北京">北京</option>
                <option value="南京">南京</option>
                <option value="上海">上海</option>
                <option value="杭州">杭州</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" name="qq" value="${user.qq}"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="email" value="${user.email}"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
<%--            reset的按钮不可以添加事件,所以我们可以通过js事件来操作,重置表单与赋值下拉框这个两个事件--%>
<%--            <input class="btn btn-default" type="reset" onclick="GenderAddress()" value="重置"/>--%>
            <input class="btn btn-default" type="button" onclick="ResetButton()"  value="重置"/>
            <input class="btn btn-default" type="button" id="ReturnList" value="返回"/>

        </div>
    </form>
</div>
</body>
<script>

    var GenderAddress = function () {
        //这一块是性别的判断
        var arrGender = document.getElementsByName("gender");
        var realGender = "${user.gender}";
        for (var i of arrGender) {
            if (i.value == realGender) {

                i.checked = true;
            }
        }

        //这一块是select的判断
        var arrSel = document.getElementsByTagName("option");

        var realAddress = "${user.address}";

        for (var i of arrSel) {

            if (i.value == realAddress) {

                i.selected = true;
            }
        }
    }


    window.onload = function (ev) {


        GenderAddress();

        //这一块是判断是否修改成功
        setTimeout(() => {

            var updateResult = "${success}";
            console.log(updateResult);

            if (updateResult == 'true') {

                alert("修改成功");

            }
            console.log("定时器生效");

        }, 500)();


    }

    //点击返回 ,返回到list页面  ReturnList
    var ReturnList = document.getElementById("ReturnList");
    ReturnList.onclick = function () {
        console.log("返回");
        location.href = "${pageContext.request.contextPath}/userListServlet";

    }


    //重置按钮的js操作
    var ResetButton=function () {
       console.log("重置3");
        //首先是form表单重置

       //这个获取到的是一个数组,所以要取  [0]
        document.getElementsByTagName("form")[0].reset();

          //给下拉框,单选框传数据

        GenderAddress();

    }
</script>
</html>