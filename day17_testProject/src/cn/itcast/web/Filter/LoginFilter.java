package cn.itcast.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;//强制转换

        String URI=request.getRequestURI();

//        System.out.println(URI);
        if(URI.contains("/login.jsp")||URI.contains("/checkCode")||URI.contains("/loginServlet")||URI.contains("/css/")||URI.contains("/js/")||URI.contains("/fonts/")){
            //说明要登录，放行

            chain.doFilter(req, resp);
        }else {
            //不包含，验证用户是否登录
            Object user=request.getSession().getAttribute("user");
            if(user!=null){
                //登录了，放行
                chain.doFilter(req,resp);
            }
            else{
                //没有登录过
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
