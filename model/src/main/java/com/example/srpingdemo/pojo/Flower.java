package com.example.srpingdemo.pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Flower {

    @Value("#{systemProperties['name']}")
    String name;

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                '}';
    }
}
