package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount(int cid,String rname) {
    //    String sql="select count(*) from tab_route where cid=?";
        String sql="select count(*) from tab_route where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);

        List<Object> list=new ArrayList<Object>();

        if(cid!=0){
            sb.append(" and cid=? ");
            list.add(cid);
        }
        if(rname!=null&&rname.length()>0&&!rname.equals("null")){
            sb.append(" and rname like ? ");
            list.add("%"+rname+"%");
        }
        sql=sb.toString();

        return template.queryForObject(sql,Integer.class,list.toArray());
    }

    @Override
    public List<Route> findListRoute(int start, int pageSize, int cid,String rname) {
       // String sql="select * from tab_route where cid=? limit ?,? ";
        String sql="select * from tab_route where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);

        List<Object> list=new ArrayList<Object>();

        if(cid!=0){
            sb.append(" and cid=? ");
            list.add(cid);
        }
        if(rname!=null&&rname.length()>0&&!"null".equals(rname)){
            sb.append(" and rname like ? ");
            list.add("%"+rname+"%");
        }
        sb.append(" limit ?,?");
        list.add(start);
        list.add(pageSize);
        sql=sb.toString();

        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),list.toArray());
    }

    @Override
    public Route findRoute(int rid) {
        String sql="select * from tab_route where rid=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Route>(Route.class),rid);
    }


}
