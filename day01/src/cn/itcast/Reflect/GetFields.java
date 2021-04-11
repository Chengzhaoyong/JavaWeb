package cn.itcast.Reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Field;

public class GetFields {
      //Field[] getFields():获取所有public 修饰的成员变量
      //Filed getField(String name):获取指定的public 修饰的成员变量


    public static void main(String[] args) throws Exception {
        Class personClass=Person.class;

        Field[] fields=personClass.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
        //public java.lang.String cn.itcast.domain.Person.a

        Person p=new Person();
        Field a=personClass.getField("a");
        //获取成员变量a的值
        Object value=a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p,"zhangshan");
        System.out.println(p);

        System.out.println("==============");
        //Field[] getDeclaredFields():获取所有的成员变量
        //Filed getDeclaredField(String name):获取指定的任意修饰符修饰的成员变量

        //所有的成员变量都可以获取
        Field[] fields1=personClass.getDeclaredFields();
        for(Field field1:fields1){
            System.out.println(field1);
        }

        Field a1=personClass.getDeclaredField("d");
        //获取成员变量a的值
        //想要访问私有的，就要忽略访问权限修饰符的检查
        a1.setAccessible(true);//暴力反射
        Object value1=a1.get(p);
        System.out.println(value1);

        a1.set(p,"lisi");
        System.out.println(p);

    }

}
