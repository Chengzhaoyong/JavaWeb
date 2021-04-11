package cn.itcast.Reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Method;

public class getMethods {
    public static void main(String[] args) throws Exception {
        Class personClass= Person.class;

       Method[] methods=personClass.getMethods();
       for(Method method:methods){
            System.out.println(method);
        }

        System.out.println("------------");
       //获取指定名称的方法
       Method method=personClass.getMethod("cat");
       Person p=new Person();
       //执行方法   invoke
        method.invoke(p);

        Method method1=personClass.getMethod("dog",String.class);
        method1.invoke(p,"狗哥");


    }
}
