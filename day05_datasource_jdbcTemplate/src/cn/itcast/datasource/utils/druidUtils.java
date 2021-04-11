package cn.itcast.datasource.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.sql.StatementEvent;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class druidUtils {
    private static DataSource ds;
   static {

       try {
           Properties pro=new Properties();
           InputStream is=druidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
           pro.load(is);
           ds=DruidDataSourceFactory.createDataSource(pro);

       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   public static  DataSource getDataSource(){
       return ds;
   }

   public static Connection getConnection() throws SQLException {
       return ds.getConnection();
   }

   public static void close(ResultSet rs, PreparedStatement pstms, Connection coon){
       if(rs!=null){
           try {
               rs.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       if(pstms!=null){
           try {
               pstms.close();
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
