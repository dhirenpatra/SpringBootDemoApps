package com.dhiren.springboot.mongodbdemo.mongo.controller;

import com.dhiren.springboot.mongodbdemo.mongo.entity.AppEntity;
import com.dhiren.springboot.mongodbdemo.mongo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientsController {

    private ClientService clientService;

    @Autowired
    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public AppEntity createEntity(@RequestBody AppEntity appEntity) {
        return clientService.persistClient(appEntity);
    }
}
