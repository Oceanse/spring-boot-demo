package com.example.srpingdemo.mock;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
   public int age=1;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void add(String name){
        System.out.println("增加了用户: "+name);
    }

}
