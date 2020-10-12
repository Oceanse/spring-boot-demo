package com.example.srpingdemo.mongo;


/**
 * @Document(collection="my_testResourceinfo") 可以不在此设置
 * 可以在Dao层查询中指明集合名：mongoTemplate.find(query, TestResourceinfo.class, collectionName);
 */
public class TestResourceinfo {
    private String jarFilePath;
    private String resourceId;


    public String getJarFilePath() {
        return jarFilePath;
    }

    public void setJarFilePath(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
