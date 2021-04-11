package cn.itcast.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.lang.reflect.Method;

public class CheckTest {
    public static void main(String[] args) throws Exception{
      Calculator c=new Calculator();
     //获取字节码对象
      Class cls=c.getClass();
      Method[] mehtods=cls.getMethods();
      int number=0;

      //io流
        BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));

      for (Method method:mehtods){
          if(method.isAnnotationPresent(Check.class)){
              try {
                  method.invoke(c);
              }catch (Exception e){
                    number++;
                    bw.write(method.getName()+"方法出现异常");
                    bw.newLine();
                    bw.write("异常名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("----------------------");
                    bw.newLine();
              }
          }
      }

      bw.write("本次测试一共有"+number+"个异常");
      bw.flush();
      bw.close();
    }
}
