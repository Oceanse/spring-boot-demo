package com.example.springboot.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 通过@Document注解指定操作的集合名，把此model映射到数据库的中的my_user集合
  另外还可以在CRUD中指定集合名称,详见TestResourceinfoRepositoryCustomImpl
  当然也可以不指定集合名称，那么CRUD中默认对应的集合名称是把Model类的首字母小写(类似于bean的id),这里会生成use集合
*/
@Document(collection="my_user")
public class User implements Serializable {

    @Id//将name设置为主键，数据库中对应的字段变成_id
   public String name;

    public int age;

    public List<Map<String,Integer>> score;

    public String hobby;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Map<String, Integer>> getScore() {
        return score;
    }

    public void setScore(List<Map<String, Integer>> score) {
        this.score = score;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
