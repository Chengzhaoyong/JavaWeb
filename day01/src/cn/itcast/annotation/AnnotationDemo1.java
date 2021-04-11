package cn.itcast.annotation;

import java.util.Date;
/*
   JDK预定义的注解
   @Override :检测被该注解的方法是否继承父类（接口）
   @Deprecated: 该注解的内容，表示过时
   @SuppressWarnings: 压制警告
 */
@SuppressWarnings("all")  //压制多有警告
public class AnnotationDemo1 {

    @Override
    public String toString() {
        return super.toString();
    }
    @Deprecated
    public void show1(){
        //过时方法
    }


    public void show2(){
        //替代show()方法

    }
    public void demo(){
        show1();
        Date d=new Date();
        d.getMonth();
    }


}
