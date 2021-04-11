package cn.itcast.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3P0Demo1 {
    public static void main(String[] args) throws Exception{
        //1 获取连接池对象
        DataSource ds=new ComboPooledDataSource();
        //2 获取连接对象
        Connection coon=ds.getConnection();

        System.out.println(coon);

    }
}
