package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImgDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
private RouteDao routeDao=new RouteDaoImpl();
private SellerDao sellerDao=new SellerDaoImpl();
private RouteImgDao routeImgDao=new RouteImgDaoImpl();
private FavoriteDao favoriteDao=new FavoriteDaoImpl();

    @Override
    public PageBean<Route> findAllByPage(int currentPage, int pageSize, int cid,String rname) {
        PageBean<Route> pb=new PageBean<Route>();
        int totalCount=routeDao.findTotalCount(cid,rname);
        pb.setTotalCount(totalCount);

        int start=(currentPage-1)*pageSize;
        List<Route> list= routeDao.findListRoute(start,pageSize,cid,rname);
        pb.setList(list);

        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        int totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        pb.setTotalPage(totalPage);


        return pb;
    }

    public Route findDetail(int rid){
        Route route=routeDao.findRoute(rid);
        Seller seller=sellerDao.findSeller(route.getSid());
        route.setSeller(seller);

        List<RouteImg> list= routeImgDao.findRouteImg(rid);
        route.setRouteImgList(list);

        //收藏次数
      int count=favoriteDao.loveCount(rid);
      route.setCount(count);

        return route;
    }
}
