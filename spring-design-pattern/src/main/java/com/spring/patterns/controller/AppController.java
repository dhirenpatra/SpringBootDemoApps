/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.controller;


import com.spring.patterns.builder.Contact;
import com.spring.patterns.builder.ContactBuilder;
import com.spring.patterns.factory.Pet;
import com.spring.patterns.factory.PetFactory;
import com.spring.patterns.repository.PresidentEntity;
import com.spring.patterns.repository.PresidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
public class AppController {

    private PetFactory petFactory;
    private PresidentRepository repository;
    private RestTemplate restTemplate;

    @Autowired
    public AppController(PetFactory petFactory, PresidentRepository repository, RestTemplate restTemplate) {
        this.petFactory = petFactory;
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String getDefault(){
        return "{\"message\": \"Hello World\"}";
    }

    @PostMapping("adoptType/{type}/{name}")
    public Pet adoptPet(@PathVariable String type, @PathVariable String name ) {
        Pet pet = petFactory.getPet(type);
        pet.setName(name);
        return pet;
    }

    @GetMapping("/presidents")
    public List<Contact> getAllContacts(){
        return Collections.unmodifiableList(Arrays.asList(
                new ContactBuilder().setEmail("abc@xyz.com").setFirstName("Dhiren").setLastName("Kumar").buildContact(),
                new ContactBuilder().setEmail("abbc@xyz.com").setFirstName("Dhiren").setLastName("Kumar").buildContact(),
                new ContactBuilder().setEmail("abcc@xyz.com").setFirstName("Dhiren").setLastName("Kumar").buildContact()
        ));
    }

    @GetMapping("/presidents/{id}")
    public PresidentEntity getPresident(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @GetMapping("/presidentContact/{id}")
    public Contact getPresidentContact(@PathVariable Long id) {
        final PresidentEntity presidentEntity = restTemplate.getForObject("http://localhost:5151/presidents/{id}",
                PresidentEntity.class, id);

        return new ContactBuilder()
                .setFirstName(presidentEntity.getFirstName())
                .setLastName(presidentEntity.getLastName())
                .setEmail(presidentEntity.getEmail())
                .buildContact();
    }

}
