package com.example.springboot.bind_value_to_bean;

import com.example.springboot.pojo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadInfo {

    @Autowired
    Person p;

    @Autowired
    Duck duck;

    @Autowired
    Flower flower;

    @Autowired
    Cat cat;

    @Autowired
    Cat2 cat2;

    @Autowired
    Rectangle rectangle;

    private static final Logger LOG = LogManager.getLogger(ReadInfo.class);


    public String showPerson() {
        LOG.debug("personInfo is: "+p.toString());
        return p.toString();
    }


    public String showDuck(){
        LOG.debug("DuckInfo is: "+duck.toString());
        return duck.toString();
    }

    public String showFlower(){
        LOG.debug("flowerInfo is: "+flower.toString());
        return flower.toString();
    }

    public String showCat(){
        LOG.debug("catInfo is: "+cat.toString());
        return cat.toString();
    }

    public String showCat2(){
        LOG.debug("cat2Info is: "+cat2.toString());
        return cat2.toString();
    }

    public String showRectangle(){
        LOG.debug("rectangleInfo is: "+rectangle.toString());
        return rectangle.toString();
    }

}
