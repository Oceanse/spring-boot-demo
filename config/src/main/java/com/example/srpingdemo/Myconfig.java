package com.example.srpingdemo;

import com.example.srpingdemo.pojo.Bot;
import com.example.srpingdemo.pojo.Mobile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;



@Configuration//该类也是一个bean,要在启动类所在包下面
public class Myconfig {

    @Bean
    public Bot bot(){
        System.out.println("asasasas");
        return new Bot();
    }

    /*@Bean
    public Person person(){
        return new Person();
    }*/
}

//@Component+@Bean 注册bean
@Component
class MyComponent{


    @Bean
    public Mobile mobile(){
        return new Mobile();
    }

}






