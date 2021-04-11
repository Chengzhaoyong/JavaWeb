package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
/*
selector 选择器
 */
public class demo4 {
    public static void main(String[] args) throws IOException {
        //获取Document对象
        String path=demo1.class.getClassLoader().getResource("student.xml").getPath();

        //2解析xml文档，获取DOM树
        Document document= Jsoup.parse(new File(path),"UTF-8");
        //获取id为itcast的student标签对象
        Elements elements=document.select("student[id=\"itcast\"]");
        System.out.println(elements);
        System.out.println("----------------");

        //.获取student标签并且number属性值为heima_0001
        Elements elements2 = document.select("name[number=\"itcast_0001\"]");
        System.out.println(elements2);
        System.out.println("----------------");

    }
}
