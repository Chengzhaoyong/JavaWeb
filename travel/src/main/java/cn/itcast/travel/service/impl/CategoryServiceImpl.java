package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.Categorydao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private Categorydao categorydao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        Jedis jedis = JedisUtil.getJedis();
        //    Set<String> category=jedis.zrange("category",0,-1);
        Set<Tuple> category = jedis.zrangeWithScores("category", 0, -1);
        List<Category> list = null;
        if (category == null || category.size() == 0) {
            System.out.println("数据库查询");
            list = categorydao.findAll();
            for (int i = 0; i < list.size(); i++) {
                jedis.zadd("category", list.get(i).getCid(), list.get(i).getCname());
            }
        } else {
            System.out.println("redis查询");
            list = new ArrayList<Category>();
            for (Tuple tuple : category) {
                Category category1 = new Category();
                category1.setCname(tuple.getElement());
                category1.setCid((int)tuple.getScore());
                list.add(category1);
            }
        }
        return list;
    }
}
