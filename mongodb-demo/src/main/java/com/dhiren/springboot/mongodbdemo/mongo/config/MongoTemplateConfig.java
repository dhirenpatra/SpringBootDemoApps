/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodbdemo.mongo.config;

import com.dhiren.springboot.mongodbdemo.mongo.app.MultipleClientConfig;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

@Configuration
@EnableMongoRepositories(basePackages = "com.dhiren.springboot.mongodbdemo.mongo.repo")
public class MongoTemplateConfig extends AbstractMongoClientConfiguration {

    private MultipleClientConfig clientConfig;

    @Autowired
    public MongoTemplateConfig(MultipleClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    @Override
    public MongoClient mongoClient() {

        MongoCredential credential = MongoCredential.createCredential(
                "dhiren", getDatabaseName(), "zxcvbnm".toCharArray());

        MongoClientOptions options = new MongoClientOptions.Builder().sslEnabled(false).build();

        return MongoClients.create(MongoClientSettings.builder()
                .credential(credential)
                .build());
    }

    @Override
    protected String getDatabaseName() {
        return "mongodemo";
    }

    @Bean public MongoTemplate mongoTemplate() {
        final Index index = new Index("expiryTime", Sort.Direction.DESC);
        final MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        clientConfig.getClients().forEach(client -> {
            index.expire(Integer.valueOf(client.getTtl()));
            mongoTemplate.indexOps(client.getCollection()).ensureIndex(index);
        });

        MappingMongoConverter mmc = (MappingMongoConverter) mongoTemplate.getConverter();
        mmc.setCustomConversions(this.mongoCustomConversions());
        mmc.afterPropertiesSet();

        return mongoTemplate;
    }

    @Bean public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoClientDbFactory(mongoClient(), getDatabaseName());
    }

    @Bean
    public MongoCustomConversions mongoCustomConversions() {

        return new MongoCustomConversions(
                Arrays.asList(new MongoReadConverter(), new MongoWriteConverter())
        );

    }

}
