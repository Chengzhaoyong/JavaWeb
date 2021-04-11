package cn.itcast.jdbcTemplate;

import cn.itcast.datasource.utils.druidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class demo1 {
    public static void main(String[] args) {
        JdbcTemplate template=new JdbcTemplate(druidUtils.getDataSource());

        String sql="update account set balance=? ";
        int count=template.update(sql,2030);
        System.out.println(count);
    }
}
