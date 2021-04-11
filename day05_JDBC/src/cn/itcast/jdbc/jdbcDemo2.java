package cn.itcast.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class jdbcDemo2 {
    public static void main(String[] args) {
        Connection  coon=null;
        Statement stms=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             coon= DriverManager.getConnection("jdbc:mysql:///db2","root","root");
            String sql="INSERT INTO account values(NULL,'周錦彬',222211)";
             stms=coon.createStatement();

            int result=stms.executeUpdate(sql);
            System.out.println(result);

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
