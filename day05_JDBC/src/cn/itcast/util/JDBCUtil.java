package cn.itcast.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    //文件只读一次就行，用静态代码块
    static {
        Properties pro=new Properties();

        //获取src下的文件的方式  类加载器
        ClassLoader classLoader=JDBCUtil.class.getClassLoader();
        URL res=classLoader.getResource("jdbc.properities");
        String resoure=res.getPath();
        //加载文件
        try {
            pro.load(new FileReader(resoure));
            url=pro.getProperty("url");
           user= pro.getProperty("user");
            driver=pro.getProperty("driver");
            password=pro.getProperty("password");

            //注册驱动

            Class.forName(driver);
       }     catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
            e.printStackTrace();
        }





    }

    public static Connection getConnection()throws Exception{
            return DriverManager.getConnection(url,user,password);

    }

    public static void close(Statement stms, Connection coon){
        if(coon!=null){
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stms!=null){
            try {
                stms.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs,Statement stms, Connection coon){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stms!=null){
            try {
                stms.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(coon!=null){
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    }

