package com.example.srpingdemo.pojo;

//验证@Config及@Bean,见MyConfig
public class Bot {
        public Bot() {
            System.out.println("bot........");
        }

    public void show() {
        System.out.println("show........");
    }


    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "name='" + name + '\'' +
                '}';
    }
}
