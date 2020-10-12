package com.example.srpingdemo.mocktest;

import com.example.srpingdemo.mock.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String name="myname";

    @Autowired
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        System.out.println("setUserDao被调用");
        this.userDao = userDao;
    }

    public void addUser(String name){
        userDao.add(name);
    }
}
