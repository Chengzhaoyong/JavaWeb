package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.domain.admin;
import cn.itcast.servlet.UserService;
import cn.itcast.servlet.impl.UserServiceImpl;
import  org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String code=request.getParameter("verifycode");
       //验证码校验
        HttpSession session=request.getSession();
        String checkcode_server= (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if(!checkcode_server.equalsIgnoreCase(code)){
            //验证码错误，存储错误信息
            request.setAttribute("login_msg","验证码错误");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        Map<String,String[]> map=request.getParameterMap();
        //封装user对象
        admin admin=new admin();
        try {
            BeanUtils.populate(admin,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //调用service查询
        UserService service=new UserServiceImpl();
        admin loginUser=service.login(admin);

        if(loginUser!=null){
            //登录成功
            //将用户存入session
            session.setAttribute("user",loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            //登录失败
            //提示信息
            session.setAttribute("login_msg","用户名或密码错误");
          request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
