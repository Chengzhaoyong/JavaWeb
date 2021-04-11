package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcLogin2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=sc.nextLine();
        System.out.println("请输入密码：");
        String password=sc.nextLine();

        boolean b=new jdbcLogin2().login(username,password);

        if(b){

            System.out.println("登录成功");
        }
        else{
            System.out.println("登录失败");
        }

    }

    public boolean login(String name,String password){
        Connection coon=null;
        PreparedStatement pstms=null;
        ResultSet result=null;
        if(name==null||password==null){
            return  false;
        }

        try {
            coon= JDBCUtil.getConnection();
            String sql="select * from user where username= ? and password= ? ";
            pstms=coon.prepareStatement(sql);

            pstms.setString(1,name);
            pstms.setString(2,password);
            result=pstms.executeQuery();
            System.out.println(sql);
            System.out.println(result.next());
            if(result.next()){
                return true;
            }
            else{
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(result,pstms,coon);
        }
        return false;
    }

}
