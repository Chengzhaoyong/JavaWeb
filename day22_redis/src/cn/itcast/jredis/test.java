package cn.itcast.jredis;

import cn.itcast.Utils.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class test {

    @Test
    public void test1(){
        Jedis jedis=new Jedis(); //localhost 6379


        jedis.set("username","zhangsan");
        jedis.close();
    }
    @Test
    public void test2(){
        Jedis jedis=new Jedis(); //localhost 6379
        jedis.hset("user","username","lisi");
        jedis.hset("user","age","33");
        //设定一个过期日期的
        jedis.setex("code",20,"2322");

      Map<String,String> map=jedis.hgetAll("user");
      Set<String> set=map.keySet();

      for(String key:set){
          String value=map.get(key);
          System.out.println(key+"--------"+value);
      }
        jedis.close();
    }
@Test
    public void test3(){
       Jedis jedis= JedisUtils.getJedis();
       jedis.set("jee","ere");
       jedis.close();
    }
}
