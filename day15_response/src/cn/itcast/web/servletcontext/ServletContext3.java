package cn.itcast.web.servletcontext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContext3")
public class ServletContext3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 javax.servlet.ServletContext context=this.getServletContext();
 //在web目录下
 String s=context.getRealPath("/b.txt");
        System.out.println(s);
        //在web-inf下
        String s1=context.getRealPath("/WEB-INF/b.txt");
        System.out.println(s1);

        //在src下
        String s2=context.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println(s2);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
