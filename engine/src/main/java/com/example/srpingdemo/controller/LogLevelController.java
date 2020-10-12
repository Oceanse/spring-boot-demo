package com.example.srpingdemo.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogLevelController {

    private static final Logger LOG = LogManager.getLogger(HelloController.class);


    @GetMapping("/showlog")
    public String speak(){
        LOG.fatal("fatal MSg===========");
        LOG.error("error MSg===========");
        LOG.warn("warn MSg===========");
        LOG.info("info MSg===========");
        LOG.debug("debug MSg===========");
        LOG.trace("trace MSg===========");
        return "Hello World!";
    }

}
