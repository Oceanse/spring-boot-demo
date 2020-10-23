package com.example.springboot;


import com.example.springboot.pojo.Flower;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:config/beans.xml"}) //使得springboot能够识别此xml配置文件
@SpringBootApplication
@EnableConfigurationProperties(Flower.class)
public class Demoapplication {
    public static void main(String[] args) {

        SpringApplication.run(Demoapplication.class,args);
    }


/*  @Bean
    public CommandLineRunner beanInfo(ApplicationContext ctx){
        return args -> {
            int beanDefinitionCount = ctx.getBeanDefinitionCount();
            System.out.println("beanDefinitionCount="+beanDefinitionCount);
            String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
            for (String beanDefinitionName : beanDefinitionNames) {
                System.out.println(beanDefinitionName);
            }
        };

    }*/




}
