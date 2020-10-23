package com.example.springboot.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 @PropertySource 加载指定的自定义属性配置文件和bean绑定
 @PropertySource 必须和@configrationproperties结合使用,当然也必须注册到spring容器中
 @PropertySource 表明从指定的配置文件获取值，@configrationproperties（prefix=）表明使用配置文件的哪一部分
 决定权：全局配置文件>@PropertySource自定义配置文件>@Value>class内属性赋值
 */
@Component
@PropertySource(value={"classpath:cat.properties"})
@ConfigurationProperties(prefix = "cat")
public class Cat2 {

    @Value("xiaomaomi")
    String name;    //@PropertySource>@value

    @Value("14")
    int age=12;// @value>class内属性赋值

    String color="white";   //@PropertySource>class内属性赋值

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}