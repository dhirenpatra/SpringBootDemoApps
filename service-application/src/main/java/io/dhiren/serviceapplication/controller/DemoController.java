package io.dhiren.serviceapplication.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${service.instance.name}")
    private String instanceName;

    @GetMapping
    public String getInstanceName() {
        return instanceName + " is responding...";
    }
}
