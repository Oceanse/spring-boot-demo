package com.example.springboot.controller;

import com.example.springboot.bind_value_to_bean.ReadInfo;
import com.example.springboot.pojo.Dog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class BasicAnnotationController {


    @Autowired
    ReadInfo readInfo;


    @Autowired
    ApplicationContext app;


    private static final Logger LOG = LogManager.getLogger(BasicAnnotationController.class);


    /**
     * @return stringInfo
     */
    @GetMapping("/hi")
    public String speak(){
       LOG.debug("Hello, Spring Boot!");
       return "Hello, Spring Boot!";
    }



    /**
     * 验证PathVariable
     *
     * @param name nameInfo
     * @param age ageInfo
     * @return total info
     */
    @GetMapping("/info/{name}/{age}")
    public String shows(@PathVariable("name") String name, @PathVariable("age")int age ){
        LOG.debug("age="+age+" "+"name="+name);
        return "My name is "+ name + " and I am " + age+" years old";
    }



    @GetMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                           @RequestParam(value = "passwd") String passwd) {
        if("ocean".equals(username) && "123".equals(passwd)){
            return "Login success!";
        }else{
            return "Login failed, please input the right username and passwd !";
        }
    }


    @GetMapping("/getHeader")
    public String getRequestHeader(@RequestHeader("Host") String host) {
        return host;
    }


    /**
     * RequestBody注解  JSON转成java对象
     * @param dog
     * @return
     */
    @PostMapping("/showDog")
    public Dog showDog(@RequestBody Dog dog){
        LOG.debug(dog);
        return dog;
    }
}
