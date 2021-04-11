package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.MalformedURLException;
import java.net.URL;

public class demo3 {
    public static void main(String[] args) throws Exception {
        URL url=new URL("http://www.gdufe.edu.cn/");
        Document document= Jsoup.parse(url,10000);
        System.out.println(document);
    }
}
