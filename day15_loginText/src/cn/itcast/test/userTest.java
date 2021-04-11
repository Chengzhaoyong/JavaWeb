package cn.itcast.test;

import cn.itcast.dao.userDao;
import cn.itcast.domain.User;
import jdk.jfr.StackTrace;
import org.junit.Test;


public class userTest {
@Test
    public void testLogin(){
    User user=new User();
    user.setUsername("张三");
    user.setPassword("123456");

    userDao userDao=new userDao();
    User user1=userDao.login(user);
    System.out.println(user1);

}

}
