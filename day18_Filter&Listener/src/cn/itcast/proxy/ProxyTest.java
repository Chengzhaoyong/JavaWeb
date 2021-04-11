package cn.itcast.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        lenovo lenovo=new lenovo();

        SaleComputer proxy_lenovo=(SaleComputer) Proxy.newProxyInstance(lenovo.class.getClassLoader(), lenovo.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

              if(method.getName().equals("sale")){
                  double money= (double) args[0];
                  //增强参数
                  money=money*0.5;
                  //增强方法体
                  System.out.println("送货上门");
                  String obj=(String) method.invoke(lenovo,money);
                  //增强返回值
                  return obj+"鼠标垫";
              }
              else{
                  Object obj=method.invoke(lenovo,args);
                  return obj;
              }

            }
        });

        Object computer=proxy_lenovo.sale(4000);
        System.out.println(computer);
    }
}
