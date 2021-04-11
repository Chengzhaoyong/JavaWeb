package cn.itcast.Reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Constructor;

public class getConstructors {
    public static void main(String[] args) throws Exception {
        Class personClass= Person.class;

     Constructor constructor= personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        Object person=constructor.newInstance("zhangsan",14);
        System.out.println(person);
        System.out.println("-------------");
      //  constructor.setAccessible(true);
        Object person2=personClass.newInstance();
        System.out.println(person2);

    }
}
