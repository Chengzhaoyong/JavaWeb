package cn.itcast.annotation;
/*
 元注解：用于描述注解的注解
    @Target:描述注解能够作用的位置
         TYPE:该注解只能作用在类
         METHOD:该注解只能作用在方法上
         FILED： 该注解只能作用在成员变量上
    @Retention: 描述注解被保留的阶段，自定义注解一般是RUNTIME
    @Documented: 描述注解是否被抽取到api文档中
    @Inherited: 描述注解是否被子类继承，子类会自动继承父类的注解
 */


import java.lang.annotation.*;

@Target(value= {ElementType.TYPE,ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno2 {
}
