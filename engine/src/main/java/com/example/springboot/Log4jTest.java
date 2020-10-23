package com.example.springboot;


import com.example.springboot.controller.BasicAnnotationController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demoapplication.class)
public class Log4jTest {


    private static final Logger LOG = LogManager.getLogger(BasicAnnotationController.class);
   @Test
    public void speak(){
        LOG.fatal("fatal MSg===========");
        LOG.error("error MSg===========");
        LOG.warn("warn MSg===========");
        LOG.info("info MSg===========");
        LOG.debug("debug MSg===========");
        LOG.trace("trace MSg===========");
    }
}
