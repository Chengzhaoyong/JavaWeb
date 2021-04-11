package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeEmailServlet")
public class ActiveEmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String code=request.getParameter("code");

        UserService service=new UserServiceImpl();
       Boolean flag= service.active(code);
       String msg=null;
       if(flag){
           //激活成功
           msg="请，<a href='http://localhost:8080/login.html'>登录</a>";
       }else{
           msg="激活失败，请联系管理员";
       }
       response.setContentType("text/html;charset=utf-8");
       response.getWriter().write(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
