package com.example.springboot.pojo;


/**
 * 验证@ImportResource(locations = {"classpath:config/beans.xml"})+bean.xml注册bean
 * @Configuration+@bean注册bean
 * Autowired注入ApplicationContext
 * @return true if contains bean of bot
 */
public class Bag {
    String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "color='" + color + '\'' +
                '}';
    }
}
