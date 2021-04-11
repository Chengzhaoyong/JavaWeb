package cn.itcast.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class druidDemo1 {
    public static void main(String[] args) throws Exception{
        //手动加入配置文件
        Properties pro=new Properties();
        InputStream is=druidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //参数要properities
        DataSource ds= DruidDataSourceFactory.createDataSource(pro);
        Connection coon=ds.getConnection();

        System.out.println(coon);
    }
}
