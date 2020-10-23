package com.example.springboot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * @ConfigurationProperties读取全局配置文件并绑定全局配置文件到类属性中
 *   1 实体类必须要有相应的set方法
 *   2 这个组件是容器中的组件，可以在实体类上使用@Component 或者在配置类(或者启动类)上使用@EnableConfigurationProperties(model.class)
 *     注解去指定这个类，或者@Bean把该类加进spring容器当中
 *
 * @PropertySource指明配置文件，若没有使用此注解，则默认使用全局配置文件application.yml/properties
 */
@Component//注册该model类到spring容器中
@ConfigurationProperties(prefix = "person")//prefix 指定配置文件里的前缀
//@Validated
public class Person {

    String height;

    //@Email
    int weight = 2;
    List<Object> list;
    Map<Object, Object> map;
    Dog dog;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height='" + height + '\'' +
                ", weight=" + weight +
                ", list=" + list +
                ", map=" + map +
                ", dog=" + dog +
                '}';
    }
}
