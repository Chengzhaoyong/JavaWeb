package cn.itcast.datasource;

import cn.itcast.datasource.utils.druidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class druidDemo2 {
    public static void main(String[] args) {
        Connection coon=null;
        PreparedStatement pstms=null;

        try {
             coon=druidUtils.getConnection();
            String sql="insert into account values(null,?,?)";
             pstms=coon.prepareStatement(sql);


            //赋值
            pstms.setString(1,"王海煜");
            pstms.setDouble(2,20000);

            int count=pstms.executeUpdate();
            System.out.println(count);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            druidUtils.close(null,pstms,coon);
        }
    }
}
