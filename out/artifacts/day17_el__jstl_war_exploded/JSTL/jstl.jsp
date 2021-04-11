<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.itcast.domain.user" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<%
    List list=new ArrayList();
    list.add(new user("王海煜",20,new Date()));
    list.add(new user("酸菜鱼",23,new Date()));
    list.add(new user("颓鱼",45,new Date()));
    list.add(new user("咸鱼",34,new Date()));

    request.setAttribute("list",list);
%>

<table border="1" width="500px" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>

    <c:forEach items="${list}" var="user" varStatus="s" >
         <tr>
             <td>${s.count}</td>
             <td>${user.name}</td>
             <td>${user.age}</td>
             <td>${user.birStr}</td>
         </tr>
    </c:forEach>>
</table>

</body>
</html>
