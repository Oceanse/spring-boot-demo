package com.example.springboot.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 验证@Value
 */
@Component
public class Duck {

    @Value("10")
    double weight;

    @Value("${person.dog.name}")//从配置文件读取值的用法
    String name;

    @Value("#{100+200}")//SpEl表达式设置某个值
    double height;

    @Value("#{systemProperties['sex']}")//从jvm参数获取sex值，但是会被全局配置文件的参数覆盖
    String sex;

    /*@Value("${person.map}")//@Valu不支持map绑定
    Map map;*/

    @Override
    public String toString() {
        return "Duck{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", sex='" + sex + '\'' +
                '}';
    }
}
