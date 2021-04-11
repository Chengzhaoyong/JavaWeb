package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.Categorydao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements Categorydao {
private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        String sql="select * from tab_category";
        List<Category> list=template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));

        return list;
    }
}
