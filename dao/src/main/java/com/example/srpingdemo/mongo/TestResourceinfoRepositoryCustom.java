package com.example.srpingdemo.mongo;


import com.example.srpingdemo.mongo.TestResourceinfo;

import java.util.List;

public interface TestResourceinfoRepositoryCustom {
    public List<TestResourceinfo> findByResourceId(String id);
    public void addTestResource(String jarFilePath, String resourceId);
}
