package cn.itcast.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=100;
        int height=50;
        //1 创建一个对象 在内存中图片对象
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);

        //美化图片
        Graphics g=image.getGraphics();
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);

        //画边框
        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);


        String s="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=4;i++){
            int index=r.nextInt(s.length());
            char c=s.charAt(index);
            sb.append(c);
            g.drawString(c+"",20*i,height/2);

        }

        String checkCode_session = sb.toString();
        //将验证码存入session
        request.getSession().setAttribute("checkCode_session",checkCode_session);
        //画线
        for(int i=0;i<2;i++){
            int x=r.nextInt(width);
            int x1=r.nextInt(width);
            int y=r.nextInt(height);
            int y1=r.nextInt(height);
            g.drawLine(x,y,x1,y1);
        }

        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
