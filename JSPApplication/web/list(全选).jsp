<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">

        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" id="exampleInputName3">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" onclick="delChoose()" >删除选中</a>

    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input  onclick="chooseAll()" type="checkbox"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="s">

            <tr>
<%--                //这边的name item 是为了在勾选删除时判断其是否为真实内容,并非标题栏--%>
                <th><input name="item" class="_checkbox" data_id="${user.id}" type="checkbox"></th>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm"
                       href="${pageContext.request.contextPath}/updateFindOneServlet?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" userid="${user.id}" onclick="checkDelete(this)">删除</a></td>
            </tr>
        </c:forEach>


    </table>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
        共16条记录，共4页
    </span>

            </ul>
        </nav>


    </div>

</div>
</body>

<script>

    //删除单个
    var checkDelete = function (ev) {

        var id = ev.getAttribute("userid");

        if (confirm("您确定要删除嘛?")) {


            location.href = "${pageContext.request.contextPath}/deleteServlet?id=" + id;
        }


    }

    //全选

    var chooseAll = function () {

        let checkBoxs = document.getElementsByClassName("_checkbox");


        for (let i of checkBoxs) {

            //设置其check
            i.checked = !i.checked;


        }


    }

    var delChoose = function () {

        //设置个数组,存选中的id
        var chooseIDArr = [];

        //获取name为item的选择框对象
        let items = document.getElementsByName("item");

         for (let item of items){

             if (item.checked==true){
                 chooseIDArr.push(item.getAttribute("data_id"));
             }
             console.log("成功");

         }

        console.log(chooseIDArr);

         if (chooseIDArr.length>0){

             if (confirm("您确定要全部删除嘛?")) {

               window.location.href = "${pageContext.request.contextPath}/deleteChooseServlet?chooseIDArr="+chooseIDArr;

             }

         }



    }


</script>
</html>
