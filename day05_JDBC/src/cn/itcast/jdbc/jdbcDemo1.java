package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo1 {
    public static void main(String[] args) throws  Exception{
       // 1.导入驱动jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //3 获取数据库连接对象
        Connection coon= DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
        //4 定义sql语句
        String sql="UPDATE account set balance=2343 where id=1";
        //5 获取执行sql对象Statement
        Statement stmt=coon.createStatement();
        //6 执行sql
        int count=stmt.executeUpdate(sql);
        System.out.println(count);
        //7 处理结果

        // 8释放资源
        coon.close();
        stmt.close();


    }
}
