package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.print.attribute.standard.PagesPerMinute;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService service=new RouteServiceImpl();
    private FavoriteService favoriteService=new FavoriteServiceImpl();

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String Page=request.getParameter("currentPage"); //当前页码
       String PageSize=request.getParameter("PageSize");//每页显示的记录数
       String cid=request.getParameter("cid");
       String rname=request.getParameter("rname");
       //处理参数
       int currentPage=0;
       if(Page!=null&&Page.length()>0){
           currentPage=Integer.parseInt(Page);
       }else{
           currentPage=1;
       }

        int pageSize=0;
        if(PageSize!=null&& PageSize.length()>0){
            pageSize=Integer.parseInt(PageSize);
        }else{
            pageSize=5;
        }
        int cid1=0;
        if(cid!=null&& cid.length()>0&&!"null".equals(cid)){
            cid1=Integer.parseInt(cid);
        }



        PageBean<Route> pb=service.findAllByPage(currentPage,pageSize,cid1,rname);
        writeValue(pb,response);



    }

//查看详情
    public void findDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String rid=request.getParameter("rid");
      Route route=service.findDetail(Integer.parseInt(rid));

      writeValue(route,response);
    }

    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String rid=request.getParameter("rid");
       User user= (User) request.getSession().getAttribute("user");
       int uid=0;
       if(user!=null){
           uid=user.getUid();
       }
       Boolean flag= favoriteService.isFavorite(rid,uid);
       writeValue(flag,response);

    }
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String rid=request.getParameter("rid");
     User user= (User) request.getSession().getAttribute("user");
     int uid=0;
     if(user==null){
         return;

     }else{
         uid=user.getUid();
     }

        favoriteService.addFavorite(rid,uid);






    }

}
