package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcShiwu {
    public static void main(String[] args) {
        Connection coon=null;
        PreparedStatement pstm1=null;
        PreparedStatement pstm2=null;


        try {

            coon= JDBCUtil.getConnection();
            coon.setAutoCommit(false);
            String sql1="update account set balance=balance-? where id=?";
            String sql2="update account set balance=balance+? where id=?";

            pstm1=coon.prepareStatement(sql1);
            pstm2=coon.prepareStatement(sql2);
            pstm1.setDouble(1,1000);
            pstm1.setInt(2,1);

            pstm2.setDouble(1,1000);
            pstm2.setInt(2,2);

            pstm1.executeUpdate();
            int i=3/0;   //异常
            pstm2.executeUpdate();

            coon.commit();
        } catch (Exception e) {
            if(coon!=null){
                try {
                    coon.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtil.close(pstm1,coon);
            JDBCUtil.close(pstm2,null);
        }

    }
}
