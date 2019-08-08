<%--
  Created by IntelliJ IDEA.
  User: gavincoder
  Date: 2019-07-31
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-cn">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="js/jquery-3.3.1.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
          integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
          crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
          integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
          crossorigin="anonymous"></script>
  <script src="https://cdn.bootcss.com/axios/0.19.0-beta.1/axios.min.js"></script>

</head>

<body>


<div class="container">

    <div class="form-group">
        <label for="name">用户名</label>
        <input type="text" name="" id="name" value="" class="form-control" placeholder="" aria-describedby="helpId">
        <span id="span"></span>
        <label for="password">密码</label>
        <input type="text" name="" id="password" class="form-control" placeholder="" aria-describedby="helpId">

    </div>

</div>






</body>

<script>
    //坚持写原生js啊啊啊啊啊啊
    window.onload = function () {


        document.getElementById("name").onblur = function () {
            //获取他的数据
            var name = this.value;


            // $.get("findUserServlet",{username:name},function (data) {
            //
            //
            //
            // });


          //   //发送axios  ajax请求
          console.log(name);
          console.log(this.value);

          // var props=new URLSearchParams();
            // props.append("name",name);



            axios({
                method: 'get',
                url: 'findUserServlet',
                data: {
                    username: name

                },
                headers: {'Content-Type':
                'application/x-www-form-urlencoded'}
            })
                .then(function (response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });







        }


    }


</script>

</html>
