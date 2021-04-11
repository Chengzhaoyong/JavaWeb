package cn.itcast.xml.jsoup;
import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class demo1 {
    public static void main(String[] args) throws IOException {
        //获取Document对象
        String path=demo1.class.getClassLoader().getResource("student.xml").getPath();

        //2解析xml文档，获取DOM树
        Document document= Jsoup.parse(new File(path),"UTF-8");

        //3.获取元素对象
       Elements elements=document.getElementsByTag("name");

       //4获取第一个name对象
        Element element=elements.get(0);

        System.out.println(element.text());
        System.out.println(element.html());

    }
}
