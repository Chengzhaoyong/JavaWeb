package cn.itcast.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;

    static {

        try {
            Properties pro=new Properties();
            InputStream is= JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            ds= DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static DataSource getDataSource(){
        return ds;
    }
    public static Connection getConnection() throws Exception{
        return ds.getConnection();
    }


}
