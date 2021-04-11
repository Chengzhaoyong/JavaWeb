package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获取请求方式
        String method=request.getMethod();
        System.out.println(method);

        //获取虚拟目录
        String context=request.getContextPath();
        System.out.println(context);
        //获取servlet路径
        String servlet=request.getServletPath();
        System.out.println(servlet);
        //获取get请求参数
        String s=request.getQueryString();
        System.out.println(s);
        //获取url
        String uri=request.getRequestURI();
        StringBuffer url=request.getRequestURL();
        System.out.println(uri);
        System.out.println(url);
        //获取协议和版本
        String protocol=request.getProtocol();
        System.out.println(protocol);
        //获取客户机ip地址
        String ip=request.getRemoteAddr();
        System.out.println(ip);

    }
}
