package cn.itcast.Reflect;


import cn.itcast.domain.Person;


public class ReflectDemo1 {
    public static void main(String[] args) throws  Exception{
        //forName("全类名"):将字节码文件加载到内存，返回class 对象
        Class cls1=Class.forName("cn.itcast.domain.Person");
        System.out.println(cls1);

        //类名.class：通过类名的属性class获取
        Class cls2= Person.class;
        System.out.println(cls2);

        //getClass()：该方法在Object定义
        Person p=new Person();
        Class cls3=p.getClass();
        System.out.println(cls3);
        //通过字节码文件在一次程序运行中，只会加载一次，不论通过哪种获取方法，都是同一个
        System.out.println(cls1==cls2);
        System.out.println(cls2==cls3);
    }

}
