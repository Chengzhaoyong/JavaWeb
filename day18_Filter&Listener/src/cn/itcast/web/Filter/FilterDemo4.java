package cn.itcast.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo4 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("可以放行吗");
        chain.doFilter(req, resp);
        System.out.println("回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
