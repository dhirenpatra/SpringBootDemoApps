package com.dhiren.springboot.mongodbdemo.mongo.services;

import com.dhiren.springboot.mongodbdemo.mongo.entity.AppEntity;
import com.dhiren.springboot.mongodbdemo.mongo.runner.PropertyInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClientService {

    private MongoTemplate mongoTemplate;
    final Map<String, String> collectionsMap ;

    @Autowired
    public ClientService(MongoTemplate mongoTemplate, PropertyInitializer initializer) {
        this.mongoTemplate = mongoTemplate;
        this.collectionsMap = initializer.collectAllCollections();
    }

    public AppEntity persistClient(AppEntity appEntity) {
        System.err.println(collectionsMap);
        String name = collectionsMap.getOrDefault(appEntity.getName().toLowerCase(), "default_collection");
        return mongoTemplate.insert(appEntity, name);
    }

}
