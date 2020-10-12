package com.example.srpingdemo.pojo;

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
