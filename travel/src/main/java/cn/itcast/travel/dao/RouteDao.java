package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {
  //查找总记录数
    int findTotalCount(int cid,String rname);
    List<Route> findListRoute(int start, int pageSize,int cid,String rname);

    Route findRoute(int rid);
}
