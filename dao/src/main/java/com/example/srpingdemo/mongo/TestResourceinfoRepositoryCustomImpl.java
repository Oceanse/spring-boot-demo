package com.example.srpingdemo.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


/**
 * 指定集合名称方式：
 * 1 通过@Document注解指定操作的集合名，把此model映射到注解对应的model类(详见User)
 * 2 可以在CRUD中指定集合名称,详见TestResourceinfoRepositoryCustomImpl
 * 当然也可以不指定集合名称，那么CRUD中默认对应的集合名称是把Model类的首字母小写(类似于bean的id)
 */
@Repository
public class TestResourceinfoRepositoryCustomImpl implements TestResourceinfoRepositoryCustom {
    private String collectionName = "my_testResourceinfo";

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<TestResourceinfo> findByResourceId(String id) {

        Query query = new Query(Criteria.where("resourceId").is(id));
        List<TestResourceinfo> testResourceinfos = mongoTemplate.find(query, TestResourceinfo.class, collectionName);
        return testResourceinfos;
    }

    @Override
    public void addTestResource(String jarFilePath, String resourceId) {
        TestResourceinfo testResourceinfo = new TestResourceinfo();
        testResourceinfo.setJarFilePath(jarFilePath);
        testResourceinfo.setResourceId(resourceId);
        mongoTemplate.insert(testResourceinfo, collectionName);//这里不指定集合的名字，数据库默认生成的集合名字是testResourceinfo
    }
}
