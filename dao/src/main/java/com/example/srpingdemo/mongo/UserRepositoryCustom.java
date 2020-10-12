package com.example.srpingdemo.mongo;

import com.example.srpingdemo.mongo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryCustom {


    //增
    public void addUser(String name,int age);
    public void addUser2(User user);

    //删
    public void delByName(String name);

    //改
    public  void updateFirstByName(String name);
    public  void updateAllByName(String name);

    //查
    public List<User> usersFindByAge(int age);
    public List<User> usersFindByName(String name);
    public User userFindByName(String name);
    public User userFindByNameAge(String name, int age);
    public User userFindByScore(int score);
    public User userFindByNameScore(String name, int score);
    public  User userFindByHobby();
    public User findByName(String name);
}
