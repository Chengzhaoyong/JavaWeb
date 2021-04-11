package cn.itcast.annotation.demo;

public class Calculator {


    @Check
    public void add(){
        int a=2/0;
        System.out.println("1+0="+(1+0));
    }
@Check
    public void sub(){
        System.out.println("1-0="+(1-0));
    }
    @Check
    public void mul(){
        System.out.println("1*0="+(1*0));
    }
    @Check
    public void div(){
        System.out.println("1/0="+(1/0));
    }

}
