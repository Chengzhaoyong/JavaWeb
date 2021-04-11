package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcLogin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=sc.nextLine();
        System.out.println("请输入密码：");
        String password=sc.nextLine();

        boolean b=new jdbcLogin().login(username,password);

        if(b){

            System.out.println("登录成功");
        }
        else{
            System.out.println("登录失败");
        }

    }

    public boolean login(String name,String password){
        Connection coon=null;
        Statement stms=null;
        ResultSet result=null;
        if(name==null||password==null){
            return  false;
        }

        try {
             coon= JDBCUtil.getConnection();
            String sql="select * from user where username='"+name+"' and password='"+password+"'";
             stms=coon.createStatement();
             result=stms.executeQuery(sql);
            System.out.println(sql);

            if(result.next()){
                return true;
            }
            else{
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(result,stms,coon);
        }
        return false;
    }

}
