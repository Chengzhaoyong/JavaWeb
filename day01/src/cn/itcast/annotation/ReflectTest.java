package cn.itcast.annotation;

import java.lang.reflect.Method;

@Pro(className ="cn.itcast.annotation.Demo2",classMethod = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class<ReflectTest> reflectTestClass=ReflectTest.class;

        //1.解析注解
        //1.1 其实在内存上生成了该注解的子类实现对象
        Pro an=reflectTestClass.getAnnotation(Pro.class);
        String className=an.className();
        String classMethod=an.classMethod();

        //3.加载该类进内存
        Class cls=Class.forName(className);
        Object obj=cls.newInstance();
        Method method=cls.getMethod(classMethod);
        method.invoke(obj);
    }

}
