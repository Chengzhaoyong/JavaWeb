package cn.itcast.web.servlet;

import cn.itcast.dao.userDao;
import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet( "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//       String username= request.getParameter("username");
//       String password=request.getParameter("password");
//
//       User user1=new User();
//       user1.setUsername(username);
//       user1.setPassword(password);

        Map<String,String[]> map=request.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        userDao userDao=new userDao();
       User userLogin=userDao.login(user);

       if (userLogin==null){
           request.getRequestDispatcher("/failServlet").forward(request,response);
       }else{
           request.setAttribute("user",userLogin);
           request.getRequestDispatcher("/sucessfulServlet").forward(request,response);
       }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
