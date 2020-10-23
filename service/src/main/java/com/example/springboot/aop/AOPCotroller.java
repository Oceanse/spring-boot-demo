package com.example.springboot.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPCotroller {

    /**
     * @return stringInfo
     */
    @GetMapping("/hi")
    public String aopTest(){
        return "Hello, Spring Boot!";
    }


}
