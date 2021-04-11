package cn.itcast.jdbcTemplate;

import cn.itcast.datasource.utils.druidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class demo2 {
    JdbcTemplate template=new JdbcTemplate(druidUtils.getDataSource());

    @Test   //不能查询多行数据
    public void method1(){
        String sql="select * from emp where id=? or id=?";
        Map<String,Object> map=template.queryForMap(sql,1);
        System.out.println(map);

    }

    @Test
    public void method2(){
        String sql="select * from emp";
        List<Map<String,Object>> list=template.queryForList(sql);
        for (Map<String,Object> map:list){
            System.out.println(map);
        }
    }
    @Test
    public void method3(){
        String sql="select count(*)from emp";
        long tatal=template.queryForObject(sql,long.class);
        System.out.println(tatal);
    }

}
