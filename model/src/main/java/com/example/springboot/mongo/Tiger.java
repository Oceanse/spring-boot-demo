package com.example.springboot.mongo;

import org.springframework.stereotype.Component;

@Component
public class Tiger {

    String tigerName;
    int age;

    public Tiger() {
    }

    public Tiger(String tigerName, int age) {
        this.tigerName = tigerName;
        this.age = age;
    }

    public String getTigerName() {
        return tigerName;
    }

    public void setTigerName(String tigerName) {
        this.tigerName = tigerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}