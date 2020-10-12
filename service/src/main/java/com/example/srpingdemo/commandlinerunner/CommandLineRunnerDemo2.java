package com.example.srpingdemo.commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component //@Component与@Bean组合注册bean
public class CommandLineRunnerDemo2 {


    //这里的@Order不起作用



    @Order(3)
    @Bean
    public CommandLineRunner loadResource(){
        System.out.println("333333");
        return args->{
            System.out.println("loadResource3======================");
        };
    }


    @Order(2)
    @Bean
    public CommandLineRunner loadResource2(){
        System.out.println("2222222");
        return args->{
            System.out.println("loadResource2======================");
        };
    }


    @Order(1)
    @Bean
    public CommandLineRunner loadResource3(){
        System.out.println("1111111");

        return args->{
            System.out.println("loadResource3======================");
        };
    }


    /**
     * 函数式接口
     */
    interface Test{
        void run();
    }



    @Bean
    public Test loadResource5(){
        System.out.println("str2======================"); //这里会被打印,因为通过@Component+@bean实现注册bean,必须执行@Bean所注解的方法
        return ()->{
            System.out.println("str======================");//这里不会被打印
        };

        /*等价于：
        return new Test(){
            @Override
            void run(){
                System.out.println("str======================");
            }
        }*/
    }



}
