package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet( "/ServletDownLoad")
public class ServletDownLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String filename=request.getParameter("filename");
     ServletContext context=this.getServletContext();
     String path=context.getRealPath("/img/"+filename);
        System.out.println(path);
     //字节流加载进内存
        FileInputStream fis=new FileInputStream(path);

         String mime=context.getMimeType(filename);
        //设置响应头
        response.setHeader("content-type",mime);
        response.setHeader("content-disposition","attachment;filename="+filename);

        //将输入流的数据写入输出流
        ServletOutputStream sos=response.getOutputStream();
        byte[] buff=new byte[1024*8];
        int len=0;
        while((len=fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }
        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
