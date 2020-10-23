package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlMappingController {

    /**
     * 精确匹配
     * 精确模糊匹配和模糊匹配重合时，以精确匹配为主
     */
    @GetMapping("/match/precise")
    public String preciseInfo(){
        return "precise match";
    }


    /**
     * 模糊匹配
     * 精确模糊匹配和模糊匹配重合时，以精确匹配为主
     */
    @GetMapping("/match/*")
    public String blurryInfo(){
        return "blurry match";
    }

}
