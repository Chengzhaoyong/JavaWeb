package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtil;

import java.sql.*;

public class jdbcUtilDemo {
    public static void main(String[] args) throws Exception {
        Connection coon = null;
        Statement stms = null;
        ResultSet result = null;
        try {
            coon = JDBCUtil.getConnection();
            String sql = "select * from account";
            stms = coon.createStatement();

            result = stms.executeQuery(sql);
            System.out.println(result);


            //处理结果
            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString("name");
                double balance = result.getDouble(3);
                System.out.println(id + name + balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(result, stms, coon);
        }
    }
    }

