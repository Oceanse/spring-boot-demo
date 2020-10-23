package com.example.springboot;

import com.example.springboot.pojo.Bot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demoapplication.class)
public class IOCTest {

    @Autowired
    ApplicationContext app;

    @Autowired
    Bot bot;


    /**
     * 验证 启动类@ImportResource(locations = {"classpath:config/beans.xml"})+ 配置文件bean.xml注册bean
     */
    @Test
    public void containsBag(){
        System.out.println("app.containsBean(bag): "+app.containsBean("bag"));
    }



    /**
     *  @Configuration + @bean 注册bean
     *  @Configuration 用于定义配置类, 该类也是一个bean,要在启动类所在包下面
     *  @Bean 是一个方法级别上的注解，主要用在 @Configuration/@Component 注解的类里,其生成的实例会被纳入到spring容器中，并且实例名就是方法名。
     */
    @Test
    public void containsBot(){
        System.out.println("app.containsBean(bots): "+app.containsBean("bots"));
    }




    /**
     *  @Component + @bean 注册bean
     *  @Component  用于定义配置类, 该类是一个bean,要在启动类所在包下面
     *  @Bean 是一个方法级别上的注解，主要用在@Configuration/@Component等注解的类里,其生成的实例会被纳入到spring容器中，并且实例名就是方法名。
     */
    @Test
    public void contains(){
        System.out.println("app.containsBean(mobile): "+app.containsBean("mobile"));
    }

}

