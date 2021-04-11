package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class demo2 {
    public static void main(String[] args) {
        Document document=Jsoup.parse("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "\n" +
                "\n" +
                "<students>\n" +
                "<student number=\"itcast_0001\">\n" +
                "\t<name>张三</name>\n" +
                "\t<age>18</age>\n" +
                "\t<sex>male</sex>\n" +
                "</student>\n" +
                "\n" +
                "</students>");
        System.out.println(document);



    }
}
