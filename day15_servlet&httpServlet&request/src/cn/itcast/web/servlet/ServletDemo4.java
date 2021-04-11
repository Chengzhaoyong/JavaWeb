package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet( "/ServletDemo4")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");  //解决乱码问题
      //1.根据参数名称获取参数值
       String username= request.getParameter("username");
        System.out.println(username);
        String password=request.getParameter("password");
        System.out.println(password);
        System.out.println("===================");
        //2 根据参数名称获取所有参数值
        String[] parameterValues=request.getParameterValues("hobby");
        for (String name:parameterValues){
            System.out.println(name);
        }
        System.out.println("==============");
        //3.获取所有参数名称
        Enumeration<String> em=request.getParameterNames();
       while(em.hasMoreElements()){
           String s=em.nextElement();
           System.out.println(s);
       }

        System.out.println("==============");
        //4.获取所有参数集合
        Map<String,String[]> map=request.getParameterMap();
       Set<String> set=map.keySet();
       for (String name:set){
           String[] s=map.get(name);
           System.out.println(name);
           for (String name1:s){
               System.out.println(name1);
           }
       }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
