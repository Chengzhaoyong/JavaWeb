package cn.itcast.service;

import cn.itcast.dao.ProvinceDao;
import cn.itcast.dao.impl.ProvinceDaoImpl;
import cn.itcast.domain.Province;

import java.util.List;

public interface ProvinceService {


    List<Province> findAll();
    String findAllRedis();
}
