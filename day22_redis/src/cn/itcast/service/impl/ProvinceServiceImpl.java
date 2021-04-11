package cn.itcast.service.impl;

import cn.itcast.Utils.JedisUtils;
import cn.itcast.dao.ProvinceDao;
import cn.itcast.dao.impl.ProvinceDaoImpl;
import cn.itcast.domain.Province;
import cn.itcast.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private  ProvinceDao dao=new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    public String findAllRedis(){

        Jedis jedis= JedisUtils.getJedis();
       String json= jedis.get("province");
       if(json==null||json.length()==0){
           System.out.println("Redis没数据,查询数据库");
           List<Province> list=dao.findAll();
           ObjectMapper mapper=new ObjectMapper();

           try {
               json=mapper.writeValueAsString(list);
           } catch (JsonProcessingException e) {
               e.printStackTrace();
           }
           jedis.set("province",json);
           jedis.close();

       }else{
           System.out.println("redis有数据");

       }
        return json;
    }
}
