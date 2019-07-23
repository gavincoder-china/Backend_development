<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: gavincoder
  Date: 2019-07-23
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--c:if 标签
  1:属性,test  必须有 , 去接受boolean表达式
                    *如果为true,则显示标签体内容
                    *如果为false,则不显示
                    一般会结合el表达式一起使用
                    --%>

<%
    //创建一个list
    ArrayList<Object> list = new ArrayList<>();
    list.add("java");
    list.add("javascript");
    list.add("python");
    list.add("golang");
    list.add("kotlin");
    request.setAttribute("list", list);

    //创建个num变量,做choose案例
    int num = 3;
    request.setAttribute("num",num);
%>


<c:if test="${not empty list}">
    显示
</c:if>

<%--choose标签--%>
<%--完成数字编号对应星期几的案例--%>
<c:choose>
    <c:when test="${num == 1}">星期一</c:when>
    <c:when test="${num == 2}">星期2</c:when>
    <c:when test="${num == 3}">星期3</c:when>
    <c:when test="${num == 4}">星期4</c:when>
    <c:when test="${num == 5}">星期5</c:when>
    <c:when test="${num == 6}">星期6</c:when>
    <c:when test="${num == 7}">星期日</c:when>
    <c:otherwise>没有该日期</c:otherwise>

</c:choose>

<c:forEach  begin="0" end="${list.size()}" var="i" step="1"  varStatus="s" items="${list}">

   <%-- begin:开始
    end:结束
    var:遍历对象的内容==list.get(s.index)
    step:步长
    varStatus:  .index 索引
                .count 计数器,循环计数
    items:  需要遍历的对象--%>
<br>
    ${i}
    ${list.get(s.index)} <br>

</c:forEach>
</body>
</html>
