package cn.itcast.annotation;
/*
  自定义注解：
    元注解
    public @interface MyAnno extends java.lang.annotation.Annotation {}

    1.属性：接口中的抽象方法
        1.属性返回值类型有以下：
          基本数据类型
          String
          枚举
          注解
          以上类型的数组
        2.定义了属性，在使用时需要给属性赋值

 */
public @interface AnnotationDemo2 {
    int age();
    String s1() default  "张三"; //默认赋值
    Person p();
    MyAnno m();
    String[] s();

}
