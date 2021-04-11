package cn.itcast.proxy;

public class lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("我买了"+money+"的电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("show......");
    }
}
