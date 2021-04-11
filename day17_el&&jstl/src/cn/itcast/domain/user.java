package cn.itcast.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class user {
    private String name;
    private int age;
    private Date birthday;

    public user(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getBirStr(){
        if(birthday!=null){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
            String format = sdf.format(birthday);
            return format;
        }else{
            return "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
