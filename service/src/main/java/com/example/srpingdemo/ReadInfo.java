package com.example.srpingdemo;

import com.example.srpingdemo.pojo.Cat;
import com.example.srpingdemo.pojo.Flower;
import com.example.srpingdemo.pojo.MyDog;
import com.example.srpingdemo.pojo.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadInfo {

    @Autowired
    Person p;

    @Autowired
    MyDog myDog;

    @Autowired
    Flower flower;

    @Autowired
    Cat cat;

    private static final Logger LOG = LogManager.getLogger(ReadInfo.class);


    public String showPerson() {
        LOG.debug("personInfo is: "+p.toString());
        return p.toString();
    }


    public String showMyDog(){
        return myDog.toString();
    }

    public String showFlower(){
        return flower.toString();
    }

    public String showCat(){
        return cat.toString();
    }

}
