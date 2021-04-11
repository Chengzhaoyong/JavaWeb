package cn.itcast.test;

import cn.itcast.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class CalculatorTest {

    /*
    注解：资源申请和释放
     */
    @Before
    public void init(){
        System.out.println("init---");
    }

    @After
    public void close(){
        System.out.println("close---");
    }
    @Test
    public void testAdd(){
        Calculator c=new Calculator();
        int result=c.add(4,2);
        System.out.println(result);

        //万一有时候我方法写错了，测试还是绿颜色，答案不知道对不对，我们可以断言
        Assert.assertEquals(6,result);//
    }

    @Test
    public void testSub(){
        Calculator c=new Calculator();
        int result=c.sub(4,2);
        System.out.println(result);

        //万一有时候我方法写错了，测试还是绿颜色，答案不知道对不对，我们可以断言
        Assert.assertEquals(2,result);
    }
}
