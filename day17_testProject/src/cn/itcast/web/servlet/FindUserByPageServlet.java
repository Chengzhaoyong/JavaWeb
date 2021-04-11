package cn.itcast.web.servlet;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.servlet.UserService;
import cn.itcast.servlet.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setCharacterEncoding("utf-8");
       //获取参数
        String currentPage=request.getParameter("currentPage");
        String row=request.getParameter("row");

        if(currentPage==null||currentPage.equals("")||Integer.parseInt(currentPage)<1){
            currentPage="1";

        }
        if(row==null||row.equals("")){
            row="5";
        }

        //获取所有参数--查询的参数
        Map<String,String[]> condition=request.getParameterMap();

        //调用service查询
        UserService service=new UserServiceImpl();
       PageBean<User> pb= service.findUserByPage(currentPage,row,condition);
       request.setAttribute("pb",pb);
//        System.out.println(pb);
        request.setAttribute("condition",condition);
       request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
