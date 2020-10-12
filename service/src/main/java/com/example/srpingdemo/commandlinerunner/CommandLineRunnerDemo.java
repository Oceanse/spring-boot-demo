package com.example.srpingdemo.commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;


/**
 * SpringBoot在项目启动后会遍历所有实现CommandLineRunner的实体类并执行run方法
 */
@Service
@Order(value=2)
public class CommandLineRunnerDemo implements CommandLineRunner  {

    //springboot启动时会执行run方法
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行 2222 <<<<<<<<<<<<<");
    }

}

@Service
@Order(value=1)
class CommandLineRunnerDemoTwo implements CommandLineRunner  {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行 111 <<<<<<<<<<<<<");
    }

}



