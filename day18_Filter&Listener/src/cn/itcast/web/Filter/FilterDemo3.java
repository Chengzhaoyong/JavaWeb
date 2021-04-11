package cn.itcast.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    //当服务器正常关闭后，执行该方法
    public void destroy() {
        System.out.println("destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        System.out.println("doFilter");
        chain.doFilter(req, resp);

    }
//服务器开启后，调用init方法，只执行一次，用于资源加载
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init");
    }

}
