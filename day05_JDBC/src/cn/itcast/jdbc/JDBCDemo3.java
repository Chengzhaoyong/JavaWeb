package cn.itcast.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;


public class JDBCDemo3{
    public static void main(String[] args) {
        Connection  coon=null;
        Statement stms=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            coon= DriverManager.getConnection("jdbc:mysql:///db2","root","root");
            String sql="select * from account";
            stms=coon.createStatement();

            ResultSet result=stms.executeQuery(sql);
            System.out.println(result);


             //处理结果
            while(result.next()){
                int id=result.getInt(1);
                String name=result.getString("name");
                double balance=result.getDouble(3);
                System.out.println(id+name+balance);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    }
}
