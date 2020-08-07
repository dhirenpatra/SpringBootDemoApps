package com.springboot.otp.controller;

import com.springboot.otp.repository.AuthorRepository;
import com.springboot.otp.request.Author;
import com.springboot.otp.request.Wife;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/author/{id}")
    public void getAuthor(@PathVariable String id) {
        authorRepository.save(new Author(UUID.randomUUID().toString(),
                List.of(new Wife(UUID.randomUUID().toString(), new Random().nextInt()))));
        //return authorRepository.findById(id).get();
    }
}
