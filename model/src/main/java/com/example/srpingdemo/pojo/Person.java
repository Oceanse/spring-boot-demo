package com.example.srpingdemo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/*@ConfigurationProperties所注的类必须被springboot扫描并添加进容器中作为bean
spring容器才会创建一个该类的实例，然后把对应配置属性绑定进该实例
再把该实例作为bean添加进spring容器。
若没有使用@Component，可以在配置类(或者启动类)上使用@EnableConfigurationProperties(Person.class)
注解去指定这个类，或者@Bean把该类加进spring容器当中

@ConfigurationProperties指明配置文件的路径
@PropertySource指明配置文件，若没有使用此注解，则默认使用全局配置文件application.yml/properties

*/

@Component
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {

    String height;

    //@Email
    int weight=2;
    List<Object> list;
    Map<Object,Object> map;
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
