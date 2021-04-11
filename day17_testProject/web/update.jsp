<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 阳光小伙
  Date: 2020/10/13
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script>
        window.onload=function () {
           var fanhui= document.getElementById("fanhui");
           fanhui.onclick=function () {
                location.href="${pageContext.request.contextPath}/findUserByPageServlet";
               }

        }
    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
        <!--  隐藏域 提交id  根据id以后修改对应的用户-->
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" value="${user.name}" id="name" name="name"  readonly="readonly" placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender=='女'}">
            <input type="radio" name="gender"  value="男"  />男
            <input type="radio" name="gender" value="女"  checked/>女
                </c:if>
            <c:if test="${user.gender=='男'}">
                <input type="radio" name="gender" value="男" checked />男
                <input type="radio" name="gender" value="女"  />女
            </c:if>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${user.age}" id="age"  name="age" placeholder="请输入年龄" />
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <c:if test="${user.address=='广东省'}">
                <select name="address" class="form-control" id="address" >
                    <option value="广东" selected>广东省</option>
                    <option value="广西">广西省</option>
                    <option value="湖南">湖南省</option>
                </select>
            </c:if>

            <c:if test="${user.address=='广西省'}">
                <select name="address" class="form-control" id="address" >
                    <option value="广东" >广东省</option>
                    <option value="广西" selected>广西省</option>
                    <option value="湖南">湖南省</option>
                </select>
            </c:if>

            <c:if test="${user.address=='湖南省'}">
                <select name="address" class="form-control" id="address" >
                    <option value="广东" >广东省</option>
                    <option value="广西" >广西省</option>
                    <option value="湖南" selected>湖南省</option>
                </select>
            </c:if>

        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" value="${user.qq}" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" value="${user.email}" name="email" placeholder="请输入邮箱地址"/>
        </div>
        <div class="form-group">
            <label for="username">Email：</label>
            <input type="text" id="username" class="form-control" value="${user.username}" name="username" placeholder="请输入用户名："/>
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" id="password" class="form-control" value="${user.password}" name="password" placeholder="请输入密码："/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" id="fanhui" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
