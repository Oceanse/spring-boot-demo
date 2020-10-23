package com.example.springboot.ioc;

import com.example.springboot.pojo.Bot;
import com.example.springboot.pojo.Mobile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 *  @Configuration + @bean 注册bean
 *  @Configuration 用于定义配置类, 该类也是一个bean,要在启动类所在包下面
 *  @Bean是一个方法级别上的注解，主要用在@Configuration注解的类里,其生成的实例会被纳入到spring容器中，并且实例名就是方法名。
 */
@Configuration
public class CustomBeanFactory {

    @Bean
    public Bot bots(){
        System.out.println("bots................");
        return new Bot();
    }

    /*@Bean
    public Person person(){
        return new Person();
    }*/
}


/**
 * @Component + @Bean 注册bean
 */
@Component
class CustomBeanFactory2 {

    @Bean
    public Mobile mobile(){
        return new Mobile();
    }

}






