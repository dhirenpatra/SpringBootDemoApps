package io.dhiren.configclientapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
public class ConfigClientAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientAppApplication.class, args);
    }

}
