/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodbdemo.mongo.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties("my")
@EnableConfigurationProperties
public class MultipleClientConfig {

    private List<Client> clients = new ArrayList<>();

    public List<Client> getClients() {
        return clients;
    }

    public void setMenus(List<Client> clients) {
        this.clients = clients;
    }

    public static class Client {

        private String name;
        private String ttl;

        private String collection = "default_collection";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTtl() {
            return ttl;
        }

        public void setTtl(String ttl) {
            this.ttl = ttl;
        }

        public String getCollection() {
            return collection;
        }

        public void setCollection(String collection) {
            this.collection = collection;
        }

    }

}
