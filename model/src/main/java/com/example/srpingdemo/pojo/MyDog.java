package com.example.srpingdemo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

//验证@Value
@Component
public class MyDog {

    @Value("true")
    boolean b;

    //可以通过设置vm参数-Dperson.dog.name=xxx覆盖配置文件设置的值
    @Value("${person.dog.name}")
    String name;

    @Value("#{170+5}")
    double height;

    /*@Value("${person.map}")//@Valu不支持map绑定
    Map map;*/

    @Override
    public String toString() {
        return "MyDog{" +
                "b=" + b +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

}
