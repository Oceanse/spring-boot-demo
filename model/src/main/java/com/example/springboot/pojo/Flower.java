package com.example.springboot.pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @ConfigurationProperties读取全局配置文件并绑定全局配置文件到类属性中
 *   1 实体类必须要有相应的set方法
 *   2 这个组件是容器中的组件，可以在实体类上使用@Component 或者在配置类(或者启动类)上使用@EnableConfigurationProperties(model.class)
 *     注解去指定这个类，或者@Bean把该类加进spring容器当中
 *
 * @PropertySource指明配置文件，若没有使用此注解，则默认使用全局配置文件application.yml/properties
 */
@ConfigurationProperties(prefix = "flower")//@EnableConfigurationProperties(Flower.class)该注解会使得该类被注册进spring容器
public class Flower {

    @Value("#{systemProperties['name']}")//从jvm参数获取name值，但是会被全局配置文件的参数覆盖
    String name;

    String color;

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
