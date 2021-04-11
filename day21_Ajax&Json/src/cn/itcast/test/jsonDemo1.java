package cn.itcast.test;


import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class jsonDemo1 {
    @Test
    public void show() throws Exception {
        Person p = new Person();
        p.setAge(12);
        p.setName("张三");
        p.setGender("男");
        p.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);


        // mapper.writeValue(new File("E://a.txt"),p);

//        mapper.writeValue(new FileWriter("E://b.txt"),p);

        System.out.println(json);

    }
    //json 转换java对象
    @Test
    public void show2() throws IOException {


        String json="{\"name\":\"张三\",\"age\":12,\"gender\":\"男\",\"birthday\":\"2020-10-17:16:25:05\"}";
        ObjectMapper mapper = new ObjectMapper();
        Person p1 = mapper.readValue(json,Person.class);

        System.out.println(p1);

    }
}
