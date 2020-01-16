package io.dhiren.configclientapp.controller;

import io.dhiren.configclientapp.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private ApplicationConfig config;

    @Value("${some.other.property}")
    private String someOtherProperty;

    @GetMapping("/config/test")
    public String getConfig() {
        return config.getProperty() + " :: " +someOtherProperty;
    }

}
