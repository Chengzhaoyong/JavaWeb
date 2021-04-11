package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.servlet.UserService;
import cn.itcast.servlet.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //1 调用UserService完成查询
        UserService service=new UserServiceImpl();
        List<User> list=service.findAll();

        //2 将list存入request域
        request.setAttribute("users",list);
        //3.转发list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
