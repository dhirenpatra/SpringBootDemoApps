package com.dhiren.springboot.mongodbdemo.mongo.runner;

import com.dhiren.springboot.mongodbdemo.mongo.app.MultipleClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PropertyInitializer {

    private MultipleClientConfig clientConfig;

    @Autowired
    public PropertyInitializer(MultipleClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    private Function<MultipleClientConfig.Client, String> getKey = key ->  key.getName().toLowerCase();

    @Bean
    public Map<String, String> collectAllCollections() {
        return clientConfig.getClients().stream()
                .collect(Collectors.toMap(
                        getKey,
                        MultipleClientConfig.Client::getCollection
                ));
    }

}
