package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check=request.getParameter("check");
        HttpSession session=request.getSession();
        String checkcode_server=(String)session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(checkcode_server==null||!(checkcode_server.equalsIgnoreCase(check))){
            ResultInfo info=new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //把封装对象转换json对象
            ObjectMapper mapper=new ObjectMapper();
            String json=mapper.writeValueAsString(info);
            //返回数据给前端
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        Map<String ,String[]> map=request.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service=new UserServiceImpl();
        Boolean flag=service.regist(user);
        ResultInfo info=new ResultInfo();
        if(flag){
            //用户名存在
            info.setFlag(false);
            info.setErrorMsg("注册失败");
        }else{
            info.setFlag(true);


        }

        //把封装对象转换json对象
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(info);
        //返回数据给前端
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    //登录功能
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check=request.getParameter("check");
        HttpSession session=request.getSession();
        String checkcode_server=(String)session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(checkcode_server==null||!(checkcode_server.equalsIgnoreCase(check))){
            ResultInfo info=new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //把封装对象转换json对象
            ObjectMapper mapper=new ObjectMapper();
            String json=mapper.writeValueAsString(info);
            //返回数据给前端
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        Map<String,String[]> map=request.getParameterMap();

        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service=new UserServiceImpl();
        User u=service.login(user);
        ResultInfo info=new ResultInfo();
        if(u==null){
            info.setErrorMsg("用户名或密码错误");
            info.setFlag(false);
        }
        if(u!=null&&u.getStatus().equals("N")){
            info.setErrorMsg("用户尚未激活，请激活");
            info.setFlag(false);
        }

        if(u!=null&&u.getStatus().equals("Y")){
            info.setFlag(true);
            request.getSession().setAttribute("user",u);
        }

        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }
//退出功能
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();

        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    //激活功能、

    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code=request.getParameter("code");

        UserService service=new UserServiceImpl();
        Boolean flag= service.active(code);
        String msg=null;
        if(flag){
            //激活成功
            msg="请，<a href='http://localhost:8080/login.html'>登录</a>";
        }else{
            msg="激活失败，请联系管理员";
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(msg);

    }

    //查找欢迎姓名
    public void findOneName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= (User) request.getSession().getAttribute("user");
           ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),user);
    }

    }
