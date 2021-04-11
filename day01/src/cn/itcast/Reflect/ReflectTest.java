package cn.itcast.Reflect;
/*
框架类
 */

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    /*
      可以任意创建对象，执行任意对象的方法
      代码不能随意改
     */
    //1.
    public static void main(String[] args) throws Exception {
        //1.创建Properties 对象
        Properties pro=new Properties();
        //获取class 目录的配置文件
        //获取字节码的类加载器
         ClassLoader classLoader=ReflectTest.class.getClassLoader();
         //获取字节流对象
         InputStream is=classLoader.getResourceAsStream("pro.properties");
        pro.load(is);
        //获取配置文件的数据
        String className=pro.getProperty("className");
        String methodName=pro.getProperty("classMethod");

        //3.加载该类进内存
        Class cls=Class.forName(className);
        Object obj=cls.newInstance();
        Method method=cls.getMethod(methodName);
        method.invoke(obj);

    }

}
