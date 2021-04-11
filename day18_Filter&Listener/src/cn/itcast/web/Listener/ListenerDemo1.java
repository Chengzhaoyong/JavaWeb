package cn.itcast.web.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.FileInputStream;

@WebListener
public class ListenerDemo1 implements ServletContextListener{

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
  ServletContext context= sce.getServletContext();
  String value=context.getInitParameter("contextConfigLocation");
  String path=context.getRealPath(value);
  try{
      FileInputStream fis=new FileInputStream(path);
      System.out.println(fis);
  }catch (Exception e){
      e.printStackTrace();
  }
        System.out.println("ServletContext对象创建了");



    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */

        System.out.println("ServletContext对象销毁了 ");
    }


}
