package com.example.springboot.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 *  @Value 和 @ConfigurationProperties同时存在互补配合使用
 *  @Value 和 @ConfigurationProperties同时起作用时，会以@ConfigurationProperties为主
 */
@Component
@ConfigurationProperties(prefix = "rectangle")
public class Rectangle {

    @Value("1.1")
    double length;

    @Value("0.5")
    double width;


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
