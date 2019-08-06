<%--
  Created by IntelliJ IDEA.
  User: gavincoder
  Date: 2019-08-05
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<select  id="province">

  <option>--请选择省份--</option>
</select>


</body>
<script>
    window.onload = function (ev) {

        //
        // $.get(
        //     "findServlet",
        //     {},
        //     function (data) {
        //         console.log(data)
        //         //先获取select的dom
        //
        //       var province = $("#province");
        //       //2.遍历json数组
        //       $(data).each(function () {
        //         //3.创建<option>
        //         var option = "<option name='" + this.id + "'>" + this.name + "</option>";
        //
        //         //4.调用select的append追加option
        //         province.append(option);
        //
        //       })
        //     }
        // )



      $.get(
              "findServlet",
              {},
              function (data) {
                console.log(data)
                //先获取select的dom

              //  var province = document.getElementById("province");

                  var province = $("#province");
                for(let item of data){

                  console.log(item);
                  var option = "<option name='" + item.id + "'>" + item.name + "</option>";

                  province.append(option);

                }



              }
      )


    }

</script>
</html>
